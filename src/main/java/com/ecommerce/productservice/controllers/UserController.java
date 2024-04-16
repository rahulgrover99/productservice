package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.CreateUserDto;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.
                createUser(createUserDto.getName(), createUserDto.getEmail());
    }

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable(name = "name") String name) {
        return userService.getUserByName(name);
    }

}
