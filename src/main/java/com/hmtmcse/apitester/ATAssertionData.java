package com.hmtmcse.apitester;

import com.hmtmcse.tmutil.TMUtil;
import com.hmtmcse.tmutil.MapKeyValue;
import org.json.JSONObject;
import java.util.LinkedHashMap;


public class ATAssertionData {

    public AssertionHelper assertionHelper;
    public MapKeyValue userDefineKeyValue;
    public MapKeyValue apiResponseKeyValue;


    private MapKeyValue jsonObjectToKeyValue(JSONObject jsonObject, String key){
        MapKeyValue mapKeyValue = new MapKeyValue();
        try {
            mapKeyValue.value = jsonObject.get(key);
            mapKeyValue.key = key;
            return mapKeyValue;
        }catch (Exception e){
            return null;
        }
    }


    public ATAssertionData process(LinkedHashMap<String, Object> userDefine, JSONObject apiResponse){
        if (userDefine == null || apiResponse == null){
            return null;
        }

        userDefineKeyValue = TMUtil.getMapKeyValue(userDefine);
        if (userDefineKeyValue == null || userDefineKeyValue.key == null || userDefineKeyValue.value == null){
            return null;
        }

        apiResponseKeyValue = jsonObjectToKeyValue(apiResponse, userDefineKeyValue.key);
        if (apiResponseKeyValue == null || apiResponseKeyValue.value == null){
            return null;
        }



        if (userDefineKeyValue.value instanceof String){
            assertionHelper = new AssertionHelper<String>();
        }else if (userDefineKeyValue.value instanceof Float){
            assertionHelper = new AssertionHelper<Float>();
        }else if (userDefineKeyValue.value instanceof Integer){
            assertionHelper = new AssertionHelper<Integer>();
        }else if (userDefineKeyValue.value instanceof Boolean){
            assertionHelper = new AssertionHelper<Boolean>();
        }else if (userDefineKeyValue.value instanceof Double){
            assertionHelper = new AssertionHelper<Double>();
        }else if (userDefineKeyValue.value instanceof Long){
            assertionHelper = new AssertionHelper<Long>();
        }else{
            return null;
        }
        assertionHelper.apiResponseValue = (Comparable) apiResponseKeyValue.value;
        assertionHelper.userDefineValue = (Comparable) userDefineKeyValue.value;
        return this;
    }

    public static ATAssertionData instance(){
        return new ATAssertionData();
    }

}
