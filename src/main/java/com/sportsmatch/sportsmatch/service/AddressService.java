package com.sportsmatch.sportsmatch.service;

import com.sportsmatch.sportsmatch.Repository.AddressRepository;
import com.sportsmatch.sportsmatch.model.Address;
import com.sportsmatch.sportsmatch.model.dto.CepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final CepAPIService cepAPIService;

    public Long createByCep(Long cep) {
        try {
            CepDTO cepReturn = cepAPIService.findByCep(cep);

            Address newAddress = new Address();
            newAddress.setAddressCep(cep);
            newAddress.setAddressUf(cepReturn.getUf());
            newAddress.setAddressCity(cepReturn.getLocalidade());
            newAddress.setAddressStreet(cepReturn.getLogradouro());

            Address savedAddress = addressRepository.save(newAddress);
            return savedAddress.getAddressId();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
