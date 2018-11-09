package com.hmtmcse.stringhelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class HMJson {

    public static final String ARRAY = "ARRAY";
    public static final String OBJECT = "OBJECT";
    public static final String INVALID = "INVALID";


    public static Object parseJSONFromString(String content){
        return new JSONObject(content);
    }

    public static String isArrayOrObject(Object object){
        if (object instanceof JSONObject) {
            return OBJECT;
        } else if (object instanceof JSONArray) {
            return ARRAY;
        } else {
            return INVALID;
        }
    }


    public static HashMap getStringToJSONObject(String content) throws SHException {
        return (HashMap) parseJSONFromString(content);
    }


    public static List getStringToJSONArray(String content) throws SHException {
        return (List) parseJSONFromString(content);
    }
}
