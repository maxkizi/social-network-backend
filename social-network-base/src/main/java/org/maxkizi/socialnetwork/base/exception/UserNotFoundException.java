package org.maxkizi.socialnetwork.base.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super(Exceptions.USER_NOT_FOUND_EXCEPTION_MESSAGE);
    }
}
