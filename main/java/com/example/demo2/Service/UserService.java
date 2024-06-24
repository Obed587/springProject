package com.example.demo2.Service;


import com.example.demo2.Dto.UserModel;
import com.example.demo2.Entity.User;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
