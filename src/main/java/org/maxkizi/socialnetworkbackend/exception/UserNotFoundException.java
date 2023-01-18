package org.maxkizi.socialnetworkbackend.exception;

import static org.maxkizi.socialnetworkbackend.exception.Exceptions.USER_NOT_FOUND_EXCEPTION_MESSAGE;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super(USER_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}
