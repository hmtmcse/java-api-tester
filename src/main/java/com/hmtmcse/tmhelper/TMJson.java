package com.hmtmcse.tmhelper;

import com.hmtmcse.tmutil.TMUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.List;

public class TMJson {

    public static final String ARRAY = "ARRAY";
    public static final String OBJECT = "OBJECT";
    public static final String INVALID = "INVALID";


    public static Object parseJSONFromString(String content){
        try{
            return new JSONObject(content);
        }catch (Exception e){
            TMUtil.print(e.getMessage());
        }
        return null;
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


    public static HashMap getStringToJSONObject(String content){
        return (HashMap) parseJSONFromString(content);
    }


    public static List getStringToJSONArray(String content){
        return (List) parseJSONFromString(content);
    }


}
