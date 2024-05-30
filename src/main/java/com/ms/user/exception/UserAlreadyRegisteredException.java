package com.ms.user.exception;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserAlreadyRegisteredException extends Throwable {
    public UserAlreadyRegisteredException(@NotBlank @Email String s) {
    }
}
