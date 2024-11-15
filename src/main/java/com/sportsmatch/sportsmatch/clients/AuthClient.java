package com.sportsmatch.sportsmatch.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportsmatch.sportsmatch.model.Users;
import com.sportsmatch.sportsmatch.model.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthClient {

    private String baseApiUrl = "http://localhost:8000/api/v1/person/";

    @Autowired
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public UserReturnDTO registerUser(UserDTO usuario) {
        try {
            HttpHeaders headers =  new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<UserDTO> http = new HttpEntity<>(usuario,headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    baseApiUrl, HttpMethod.POST, http, Map.class
            );

            var user = objectMapper.convertValue(response.getBody(), Map.class);

            return new UserReturnDTO(
              Long.valueOf(user.get("id").toString()),
              user.get("name").toString(),
              Long.valueOf(user.get("position").toString()),
              user.get("cep").toString()
            );
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public LoginResponse loginUser(Credentials credentials) {
        try {
            HttpHeaders headers =  new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<Credentials> http = new HttpEntity<>(credentials,headers);

            ResponseEntity<LoginResponse> response = restTemplate.exchange(
                    baseApiUrl + "login", HttpMethod.POST, http, LoginResponse.class
            );

            return objectMapper.convertValue(response.getBody(), LoginResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
