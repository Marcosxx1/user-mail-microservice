package com.ms.user.controller;
import java.util.List;

import com.ms.user.dtos.RegisterUserRequest;
import com.ms.user.entity.User;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(
        value = "/user",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UUID> saveUser(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        UUID id = userService.save(registerUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
