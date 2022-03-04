package com.bilal.instaclonebackend.ExceptionHandling;

public class UserNotFound extends Exception{
    public UserNotFound(){
        super("user with the given ID do not exists");
    }

    public UserNotFound(String message){
        super(message);
    }
}
