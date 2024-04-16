package com.ecommerce.productservice.service;

import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name).get();

    }
}
