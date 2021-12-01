package com.ssh.todos.config.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
@Getter
public class ForbiddenException extends RuntimeException {
    private final String status = "401";
    private final String error = "Not Authorized";

}
