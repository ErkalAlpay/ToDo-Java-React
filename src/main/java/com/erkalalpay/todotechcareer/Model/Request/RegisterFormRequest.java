package com.erkalalpay.todotechcareer.Model.Request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterFormRequest {
    @NotEmpty @NotBlank @Email @Size(min = 8)
    String email;
    @NotEmpty @NotBlank
    @Size(min = 8)
    String password;
}
