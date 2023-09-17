package com.erkalalpay.todofullstack.Model.Request;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class RegisterFormRequest {
    @NotEmpty @NotBlank @Email @Size(min = 8, message = "{email.invalid}")
    String email;
    @NotEmpty @NotBlank
    @Size(min = 8, message = "{password.invalid}")
    String password;
}
