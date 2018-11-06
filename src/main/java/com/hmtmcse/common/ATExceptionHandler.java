package com.hmtmcse.common;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class ATExceptionHandler extends Exception {

    public ATExceptionHandler(){
        super("API Test Exception Occurred!");
    }

    public ATExceptionHandler(String message){
        super(message);
    }
}
