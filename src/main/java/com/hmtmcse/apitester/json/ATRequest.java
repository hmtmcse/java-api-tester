package com.hmtmcse.apitester.json;

import com.fasterxml.jackson.databind.JsonNode;

public class ATRequest {

    public String url;
    public String contextType = null;
    public String method;
    public JsonNode params;
    public ATResponse response;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public ATResponse getResponse() {
        return response;
    }

    public void setResponse(ATResponse response) {
        this.response = response;
    }

    public JsonNode getParams() {
        return params;
    }

    public void setParams(JsonNode params) {
        this.params = params;
    }
}
