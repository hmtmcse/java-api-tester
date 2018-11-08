package com.hmtmcse.stringhelper;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class SHException extends Exception {

    public SHException(){
        super("String Helper Exception Occurred!");
    }

    public SHException(String message){
        super(message);
    }
}
