package com.vladyslavboiko.xogametwo;

/**
 * Created by Tom on 22.09.2017.
 */

public class UserAuthException extends Exception {
    private String authCause;
    public UserAuthException(String cause){
        super(cause);
        authCause = cause;
    }
    public String getAuthExceptionCause(){
        return authCause;
    }
}
