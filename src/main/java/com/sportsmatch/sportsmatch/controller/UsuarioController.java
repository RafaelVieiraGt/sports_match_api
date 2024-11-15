package com.sportsmatch.sportsmatch.controller;

import com.sportsmatch.sportsmatch.model.Users;
import com.sportsmatch.sportsmatch.model.dto.EditPerfilDTO;
import com.sportsmatch.sportsmatch.model.dto.LoginResponse;
import com.sportsmatch.sportsmatch.model.dto.UserDTO;
import com.sportsmatch.sportsmatch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

    private final UserService userService;

    @GetMapping("get-by-id/{userId}")
    public ResponseEntity<Users> findById(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Users> createUser(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("{email}/{password}")
    public ResponseEntity<Long> login(@PathVariable("email") String email,
                                      @PathVariable("password") String password) {
        return new ResponseEntity<>(userService.login(email, password), HttpStatus.OK);
    }

    @PutMapping("edit/{userId}")
    public ResponseEntity<?> edit(@PathVariable("userId") Long userId,
                                  @RequestBody EditPerfilDTO dto) {
        userService.edit(userId, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("get-photo/{userId}")
    public ResponseEntity<Map<String, String>> getPhoto(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(userService.getPhoto(userId), HttpStatus.OK);
    }

}
