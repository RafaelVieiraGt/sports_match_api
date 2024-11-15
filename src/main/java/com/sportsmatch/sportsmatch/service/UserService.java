package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.AddressRepository;
import com.sportsmatch.sportsmatch.Repository.UsersRepository;
import com.sportsmatch.sportsmatch.clients.AuthClient;
import com.sportsmatch.sportsmatch.model.Address;
import com.sportsmatch.sportsmatch.model.Users;
import com.sportsmatch.sportsmatch.model.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final AddressRepository addressRepository;
    private final AuthClient authClient;

    public Users findById(Long userId) {
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario não Encontrado"));
        Address address = addressRepository.findById(user.getAddress()).orElse(null);

        if (address != null)
            user.setAddressStreet(address.getAddressCity());

        return user;
    }

    public Users create(UserDTO dto) {
        try {
            // Pega o CEP para fazer o login
            Address address = addressRepository.findById(Long.valueOf(dto.getCep())).orElseThrow(() -> new RuntimeException("Endereço não encontrado!"));
            dto.setCep(formatCep(address.getAddressCep()));

            UserReturnDTO userRegistered = authClient.registerUser(dto);
            Users newUserData = new Users();
            newUserData.setUserId(userRegistered.getId());
            newUserData.setAddress(address.getAddressId());
            newUserData.setActive(true);
            newUserData.setUserName(userRegistered.getName());
            newUserData.setUserFavPosition(userRegistered.getPosition());

            return usersRepository.save(newUserData);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Long login(String email, String password) {
        if (email == null || password == null)
            throw new RuntimeException("Faltam Credenciais!");

        Credentials credentials = new Credentials(
                email,
                password
        );

        LoginResponse response = authClient.loginUser(credentials);
        return response.getId();
    }

    private String formatCep(Long cep) {
        // Converte o número para uma string e preenche com zeros à esquerda, se necessário
        String cepString = String.format("%08d", cep);

        // Formata a string para o formato XXXXX-XXX
        return cepString.substring(0, 5) + "-" + cepString.substring(5);
    }

    public void edit(Long userId, EditPerfilDTO dto) {
        Users user = usersRepository.findById(userId).orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));

        if (dto.getNome() != null)
            user.setUserName(dto.getNome());

        if (dto.getDescricao() != null)
            user.setUserDescription(dto.getDescricao());

        if (dto.getPosition() != null)
            user.setUserFavPosition(dto.getPosition());

        if (dto.getFoto() != null)
            user.setUserPhoto(Base64.getMimeDecoder().decode(dto.getFoto()));

        usersRepository.save(user);
    }

    public Map<String, String> getPhoto(Long userId) {
        Map<String, String> response = new HashMap<>();
        Users user = usersRepository.findById(userId).orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));

        response.put("foto", user.getUserPhoto() != null ? Base64.getMimeEncoder().encodeToString(user.getUserPhoto()) : "") ;
        return response;
    }
}
