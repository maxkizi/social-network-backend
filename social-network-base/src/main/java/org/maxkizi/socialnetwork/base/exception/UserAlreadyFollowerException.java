package org.maxkizi.socialnetwork.base.exception;

import static org.maxkizi.socialnetwork.base.exception.Exceptions.USER_ALREADY_FOLLOWER_MESSAGE;

public class UserAlreadyFollowerException extends RuntimeException {
    public UserAlreadyFollowerException() {
        super(USER_ALREADY_FOLLOWER_MESSAGE);
    }
}
