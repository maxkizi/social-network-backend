package org.maxkizi.socialnetwork.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.maxkizi.socialnetwork.base.exception.Exceptions.USER_ALREADY_FOLLOWER_MESSAGE;

@RestControllerAdvice
public class UserFollowerServiceExceptionHandler {

    @ExceptionHandler(UserAlreadyFollowerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleUserAlreadyFollowerException() {
        return USER_ALREADY_FOLLOWER_MESSAGE;
    }
}
