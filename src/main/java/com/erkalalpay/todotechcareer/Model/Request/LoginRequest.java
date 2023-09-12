package com.erkalalpay.todotechcareer.Model.Request;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginRequest {
    @Email (message ="{email.invalid}")
    String email;
    @Length(min = 8,message = "{password.invalid}")
    String password;
}

