package com.ssh.todos.config.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class NotFoundException extends RuntimeException {
    private final String status = "404";
    private final String error = "Not Authorized";

}
