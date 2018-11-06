package com.hmtmcse.apitester;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmtmcse.apitester.json.ATRequest;
import com.hmtmcse.apitester.json.ATTestCase;
import com.hmtmcse.apitester.json.ATTestCases;
import com.hmtmcse.common.ATExceptionHandler;
import com.hmtmcse.common.HMTMUtil;
import com.hmtmcse.file.FileExceptionHandler;
import com.hmtmcse.file.FileInfo;
import com.hmtmcse.file.FileUtil;
import com.hmtmcse.http.HttpResponse;

import java.util.LinkedHashMap;
import java.util.List;



public class ATCasesProcessor {


    public void run(String jsonDirectoryLocation){
        ATTestCases atTestCases = new ATTestCases();
        List<ATTestCase> cases = atTestCases.getTestCases(jsonDirectoryLocation);
    }


    public APIResponseReport requestTo(ATRequest atRequest){

        return null;
    }


    private APIResponseReport responseProcessor(HttpResponse httpResponse){

        return null;
    }


    private String contextType(){
        return null;
    }


    private String httpMethod(){
        return null;
    }


    private LinkedHashMap<String, Object> paramsToMap(JsonNode params){
        ObjectMapper mapper = new ObjectMapper();
        try {
            LinkedHashMap<String, Object> map = mapper.convertValue(params, LinkedHashMap.class);
            return map;
        }catch (Exception e){
            HMTMUtil.print(e.getMessage());
            return null;
        }
    }


}
