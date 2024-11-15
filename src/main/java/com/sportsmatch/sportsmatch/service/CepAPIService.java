package com.sportsmatch.sportsmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportsmatch.sportsmatch.model.Address;
import com.sportsmatch.sportsmatch.model.dto.CepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CepAPIService {

    @Autowired
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CepDTO findByCep(Long cep){
        try {
            var apiUrl = "https://viacep.com.br/ws/" + cep.toString() + "/json";

            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

            return objectMapper.readValue(response.getBody(), CepDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("CEP Inválido!");
        }
    }
}
