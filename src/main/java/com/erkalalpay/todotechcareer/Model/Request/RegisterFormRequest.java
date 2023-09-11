package com.erkalalpay.todotechcareer.Model.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterFormRequest {
    @NotEmpty
    @NotNull
    @Email
    @Size(min = 8)
    String email;
    @NotEmpty
    @NotNull
    @Size(min = 8)
    String password;
}
