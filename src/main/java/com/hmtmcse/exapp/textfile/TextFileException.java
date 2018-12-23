package com.hmtmcse.exapp.textfile;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class TextFileException extends Exception {

    public TextFileException(){
        super("Text File Exception");
    }

    public TextFileException(String message){
        super(message);
    }
}
