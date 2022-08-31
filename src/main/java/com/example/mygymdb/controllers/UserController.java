package com.example.mygymdb.controllers;

import com.example.mygymdb.dto.UserDto;
import com.example.mygymdb.entity.User;
import com.example.mygymdb.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody final UserDto userDto) {
        try{
            User user = userService.createUser(dtoToEntity(userDto));
            return ResponseEntity.ok(user);
        }catch (DataIntegrityViolationException e){
            return unprocessableEntity("DataIntegrityViolationException " + e.getMessage());
        }
    }

    @GetMapping(value = "/login")
    public ResponseEntity<?> findByEmailAndPassword(@RequestParam final String email, @RequestParam final String password) {
        User user = userService.findByEmailAndPassword(email, password);
        return Objects.nonNull(user) ? ResponseEntity.ok(user) : notFound("Usuario no encontrado");
    }

    private ResponseEntity<?> unprocessableEntity(String message){
        return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private ResponseEntity<?> notFound(String message){
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    private User dtoToEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }


}
