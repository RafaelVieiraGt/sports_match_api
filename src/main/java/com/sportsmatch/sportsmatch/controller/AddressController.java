package com.sportsmatch.sportsmatch.controller;

import com.sportsmatch.sportsmatch.model.Address;
import com.sportsmatch.sportsmatch.model.dto.CepDTO;
import com.sportsmatch.sportsmatch.service.AddressService;
import com.sportsmatch.sportsmatch.service.CepAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AddressController {

    private final AddressService addressService;
    private final CepAPIService cepAPIService;

    @GetMapping("get-by-cep/{cep}")
    public ResponseEntity<CepDTO> findByCep(@PathVariable("cep") Long cep) {
        return new ResponseEntity<>(cepAPIService.findByCep(cep), HttpStatus.OK);
    }

    @PostMapping("save-by-cep/{cep}")
    public ResponseEntity<Long> saveByCep(@PathVariable("cep") Long cep) {
        return new ResponseEntity<>(addressService.createByCep(cep), HttpStatus.CREATED);
    }
}
