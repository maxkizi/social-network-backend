package org.maxkizi.socialnetworkbackend.exception;

import static org.maxkizi.socialnetworkbackend.exception.Exceptions.USER_ALREADY_FOLLOWER_MESSAGE;

public class UserAlreadyFollowerException extends RuntimeException {
    public UserAlreadyFollowerException() {
        super(USER_ALREADY_FOLLOWER_MESSAGE);
    }
}
