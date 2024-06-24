package com.example.demo2.Service.Impl;

import com.example.demo2.Dto.UserModel;
import com.example.demo2.Entity.User;
import com.example.demo2.Entity.VerificationToken;
import com.example.demo2.Repository.UserRepository;
import com.example.demo2.Repository.VerificationTokenRepository;
import com.example.demo2.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {

        User user=new User();
        user.setFirstname(userModel.getFirstname());
        user.setLastname(userModel.getLastname());
        user.setEmail(userModel.getEmail());
        user.setRole("User");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken=new VerificationToken(user,token);
        verificationTokenRepository.save(verificationToken);
    }
}
