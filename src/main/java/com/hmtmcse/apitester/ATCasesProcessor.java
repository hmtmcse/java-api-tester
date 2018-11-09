package com.hmtmcse.apitester;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmtmcse.apitester.json.*;
import com.hmtmcse.common.ATExceptionHandler;
import com.hmtmcse.tmhelper.TMJson;
import com.hmtmcse.tmutil.TMUtil;
import com.hmtmcse.http.HttpExceptionHandler;
import com.hmtmcse.http.HttpRequest;
import com.hmtmcse.http.HttpResponse;
import com.hmtmcse.http.HttpTool;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.LinkedHashMap;
import java.util.List;



public class ATCasesProcessor {


    private String baseUrl;
    private String defaultContextType;

    public void run(String jsonDirectoryLocation){
        ATTestCases atTestCases = new ATTestCases();
        List<ATTestCase> cases = atTestCases.getTestCases(jsonDirectoryLocation);
        APIResponseReport apiResponseReport;
        for (ATTestCase atTestCase: cases){
            baseUrl = atTestCase.baseUrl;
            defaultContextType = atTestCase.contextType;
            for (ATRequest atRequest: atTestCase.requests){
                apiResponseReport = new APIResponseReport();
                try {
                    apiResponseReport = requestTo(atRequest);
                } catch (ATExceptionHandler atExceptionHandler) {
                    apiResponseReport.response = atExceptionHandler.getMessage();
                }
                System.out.println("Success: " + apiResponseReport.isSuccess + " Name:" + apiResponseReport.name);
            }
        }
    }


    public APIResponseReport requestTo(ATRequest atRequest) throws ATExceptionHandler {

        if (baseUrl == null || baseUrl.equals("")){
            throw new ATExceptionHandler("Invalid Base URL");
        }
        if (atRequest.url == null || atRequest.url.equals("")){
            throw new ATExceptionHandler("Invalid Request URL");
        }
        if (defaultContextType == null && atRequest.contextType == null){
            throw new ATExceptionHandler("Invalid Context Type");
        }else if (atRequest.contextType == null){
            atRequest.contextType = defaultContextType;
        }

        HttpTool tool = HttpTool.instance().requestTo(HttpTool.urlConcat(baseUrl, atRequest.url));
        tool.setHttpMethod(httpMethod(atRequest.getMethod()));

        if (atRequest.params != null && isRowData(atRequest.contextType)){
            tool.setParams(atRequest.params.toString());
        }else{
            tool.addParams(paramsToMap(atRequest.params));
        }
        tool.setContextType(atRequest.contextType);


        APIResponseReport apiResponseReport = new APIResponseReport();
        if (atRequest.name == null || atRequest.name.equals("")){
            apiResponseReport.name = atRequest.url;
        }else{
            apiResponseReport.name = atRequest.name;
        }
        apiResponseReport.url = atRequest.url;
        apiResponseReport.method = tool.getHttpMethod();
        apiResponseReport.requestContextType = atRequest.getContextType();


        HttpResponse httpResponse;
        try {
            httpResponse = tool.send();
            apiResponseReport = responseProcessor(httpResponse, atRequest.response, apiResponseReport);
        } catch (HttpExceptionHandler httpExceptionHandler) {
            apiResponseReport.response = httpExceptionHandler.getMessage();
        }
        return apiResponseReport;
    }


    private APIResponseReport responseProcessor(HttpResponse httpResponse, ATResponse atResponse, APIResponseReport apiResponseReport){
        if (httpResponse == null){
            apiResponseReport.response = "Response Not Found.";
        }else{
            apiResponseReport.httpCode = httpResponse.getHttpCode();
            if (atResponse.httpCode != null && apiResponseReport.httpCode.equals(atResponse.httpCode)){
                apiResponseReport.isSuccess = true;
            }

            String atResponseContent = null;
            if (atResponse.content != null){
                atResponseContent = atResponse.content.toString();
            }

            if (atResponse.jsonAssertion != null){
                try {
                    apiResponseReport.isSuccess = responseAssertionCheck(atResponse.jsonAssertion, httpResponse.getContent());
                    if (!apiResponseReport.isSuccess){
                        apiResponseReport.response = httpResponse.getContent();
                    }
                } catch (ATExceptionHandler e) {
                    apiResponseReport.isSuccess = false;
                    apiResponseReport.response = e.getMessage();
                }
            }else{
                if (httpResponse.getContent().equals(atResponseContent)){
                    apiResponseReport.response = atResponseContent;
                }else{
                    apiResponseReport.isSuccess = false;
                    apiResponseReport.response = atResponseContent;
                }
            }
        }
        return apiResponseReport;
    }


    private Boolean assertionResolver(ATResponseAssertion atResponseAssertion, JSONObject jsonObject, Boolean isAnd) {
        Boolean orCondition = false;
        Boolean andCondition = false;
        ATAssertionData atAssertionData;

        if (atResponseAssertion.equal != null) {
            atAssertionData = ATAssertionData.instance().process(atResponseAssertion.equal, jsonObject);
            if (atAssertionData == null) {
                orCondition = false;
                andCondition = false;
            } else {
                if (atAssertionData.assertionHelper.isEqual()) {
                    orCondition = true;
                    andCondition = true;
                } else {
                    andCondition = false;
                }
            }
        }


        if (atResponseAssertion.notEqual != null) {
            atAssertionData = ATAssertionData.instance().process(atResponseAssertion.notEqual, jsonObject);
            if (atAssertionData == null) {
                orCondition = false;
                andCondition = false;
            } else {
                if (atAssertionData.assertionHelper.notEqual()) {
                    orCondition = true;
                    andCondition = true;
                } else {
                    andCondition = false;
                }
            }
        }


        if (atResponseAssertion.lessThan != null) {
            atAssertionData = ATAssertionData.instance().process(atResponseAssertion.lessThan, jsonObject);
            if (atAssertionData == null) {
                orCondition = false;
                andCondition = false;
            } else {
                if (atAssertionData.assertionHelper.lessThan()) {
                    orCondition = true;
                    andCondition = true;
                } else {
                    andCondition = false;
                }
            }
        }


        if (atResponseAssertion.lessThanEqual != null) {
            atAssertionData = ATAssertionData.instance().process(atResponseAssertion.lessThanEqual, jsonObject);
            if (atAssertionData == null) {
                orCondition = false;
                andCondition = false;
            } else {
                if (atAssertionData.assertionHelper.lessThanEqual()) {
                    orCondition = true;
                    andCondition = true;
                } else {
                    andCondition = false;
                }
            }
        }


        if (atResponseAssertion.greaterThan != null) {
            atAssertionData = ATAssertionData.instance().process(atResponseAssertion.greaterThan, jsonObject);
            if (atAssertionData == null) {
                orCondition = false;
                andCondition = false;
            } else {
                if (atAssertionData.assertionHelper.greaterThan()) {
                    orCondition = true;
                    andCondition = true;
                } else {
                    andCondition = false;
                }
            }
        }


        if (atResponseAssertion.greaterThanEqual != null) {
            atAssertionData = ATAssertionData.instance().process(atResponseAssertion.greaterThanEqual, jsonObject);
            if (atAssertionData == null) {
                orCondition = false;
                andCondition = false;
            } else {
                if (atAssertionData.assertionHelper.greaterThanEqual()) {
                    orCondition = true;
                    andCondition = true;
                } else {
                    andCondition = false;
                }
            }
        }
        return isAnd ? andCondition : orCondition;
    }


    private Boolean responseAssertionCheck(ATJsonAssertion atJsonAssertion, String httpResponse) throws ATExceptionHandler {
        Object object = TMJson.parseJSONFromString(httpResponse);
        JSONObject jsonObject;
        switch (TMJson.isArrayOrObject(object)) {
            case TMJson.ARRAY:
                JSONArray jsonArray = (JSONArray) object;
                if (jsonArray.length() == 0){
                    jsonObject = null;
                }else {
                    jsonObject = (JSONObject) jsonArray.get(0);
                }
                break;
            case TMJson.OBJECT:
                 jsonObject = (JSONObject) object;
                break;
            default:
                return false;
        }

        if (atJsonAssertion.and != null){
            return assertionResolver(atJsonAssertion.and, jsonObject, true);
        }else {
            return assertionResolver(atJsonAssertion, jsonObject, false);
        }

    }


    private Boolean isRowData(String contextType) {
        if (contextType != null) {
            contextType = contextType.toLowerCase();
            switch (contextType) {
                case HttpRequest.APPLICATION_JSON:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }


    private String httpMethod(String method) throws ATExceptionHandler {
        if (method == null || method.equals("")){
            throw new ATExceptionHandler("Invalid Request Method");
        }
        method = method.toUpperCase();
        switch (method) {
            case HttpRequest.POST:
                return HttpRequest.POST;
            case HttpRequest.PUT:
                return HttpRequest.PUT;
            case HttpRequest.DELETE:
                return HttpRequest.DELETE;
            case HttpRequest.GET:
                return HttpRequest.GET;
            default:
                throw new ATExceptionHandler("Invalid Request Method");
        }
    }


    private LinkedHashMap<String, Object> paramsToMap(JsonNode params){
        if (params == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            LinkedHashMap<String, Object> map = mapper.convertValue(params, LinkedHashMap.class);
            return map;
        }catch (Exception e){
            TMUtil.print(e.getMessage());
            return null;
        }
    }


}
