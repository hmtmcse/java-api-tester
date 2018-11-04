package com.hmtmcse.common;

import java.io.File;

public class HMTMUtil {



    public static void print(Object object){
        if (HMTMConfigHolder.isDebug){
            System.out.println(object);
        }
    }


    public static String concatLocation(String first, String second){
        if (first.endsWith("/") || first.endsWith("\\")){
            return first + second;
        }else {
            return first + File.separator + second;
        }
    }



}
