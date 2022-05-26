package com.rinot22.photoz_clone.service;

import com.rinot22.photoz_clone.model.UserModel;
import com.rinot22.photoz_clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<UserModel> get() {
        return userRepository.findAll();
    }

    public UserModel get(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    public UserModel save(String userName, String email, String password) {
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }
}
