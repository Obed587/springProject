package com.example.demo2.Controller;


import com.example.demo2.Dto.UserModel;
import com.example.demo2.Entity.User;
import com.example.demo2.Event.RegisterationCompleteEvent;
import com.example.demo2.Repository.VerificationTokenRepository;
import com.example.demo2.Service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class RegisterationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){

        User user=userService.registerUser(userModel);
        publisher.publishEvent(new RegisterationCompleteEvent(user,applicationurl(request)));
        return "Success";
    }

    private String applicationurl(HttpServletRequest request) {

        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
