package com.ssh.todos.config.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadResponseHandler  {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ForbiddenException.class)
    public ErrorInfoVO ForbiddenException(ForbiddenException ex) {
        ErrorInfoVO errorInfoVO = new ErrorInfoVO();
        errorInfoVO.setStatus(ex.getStatus());
        errorInfoVO.setError(ex.getError());
        return errorInfoVO;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorInfoVO NotFoundException(NotFoundException ex) {
        ErrorInfoVO errorInfoVO = new ErrorInfoVO();
        errorInfoVO.setStatus(ex.getStatus());
        errorInfoVO.setError(ex.getError());
        return errorInfoVO;
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(NotFoundException.class)
//    public ErrorInfoVO RuntimeException(RuntimeException ex) {
//        ErrorInfoVO errorInfoVO = new ErrorInfoVO();
//        errorInfoVO.setStatus("500");
//        errorInfoVO.setError("Server Error");
//        return errorInfoVO;
//    }



}
