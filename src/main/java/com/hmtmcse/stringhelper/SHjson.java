package com.hmtmcse.stringhelper;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;

public class SHjson {

    public static final String ARRAY = "ARRAY";
    public static final String OBJECT = "OBJECT";
    public static final String INVALID = "INVALID";


    public static Object parseJSONFromString(String content) throws SHException {
        try {
            JSONParser jsonParser = new JSONParser();
            return jsonParser.parse(content);
        } catch (ParseException e) {
            throw new SHException(e.getMessage());
        }
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


    public static JSONArray getStringToJSONArray(String content) throws SHException {
        return (JSONArray) parseJSONFromString(content);
    }



    public static JSONObject getStringToJSONObject(String content) throws SHException {
        return (JSONObject) parseJSONFromString(content);
    }


    public static void printJSONArray(JSONArray jsonArray){
        if (jsonArray != null){
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }else{
            System.out.println("Invalid SHjson Array");
        }
    }
}
