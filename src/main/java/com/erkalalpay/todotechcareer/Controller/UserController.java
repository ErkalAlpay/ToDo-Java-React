package com.erkalalpay.todotechcareer.Controller;

import com.erkalalpay.todotechcareer.Model.Request.RegisterFormRequest;
import com.erkalalpay.todotechcareer.Service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;


    public String userRegister(RegisterFormRequest request) {
        if (userService.findByEmailForDuplacite(request.getEmail())) {
        String token = userService.create(request);
        return token;
        }else return null;
    }
}
