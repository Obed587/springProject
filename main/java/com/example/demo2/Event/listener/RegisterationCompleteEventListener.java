package com.example.demo2.Event.listener;

import com.example.demo2.Entity.User;
import com.example.demo2.Event.RegisterationCompleteEvent;
import com.example.demo2.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegisterationCompleteEventListener implements ApplicationListener<RegisterationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegisterationCompleteEvent event) {
        // Create Verification token for the user
        User user= event.getUser();
        String token= UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        //Send Mail to user
        String url=event.getApplicationUrl() + "verifyRegisteration?token=" + token;

        //Send Verification Email
        log.info("Click the link to Verify Account {}", url);
    }
}
