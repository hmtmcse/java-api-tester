package com.hmtmcse.apitester.json;

import com.fasterxml.jackson.databind.JsonNode;

public class ATResponse extends ATResponseAssertion {

    public Integer httpCode;
    public String contextType = null;
    public JsonNode content;
    public ATResponseAssertion and;


    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public JsonNode getContent() {
        return content;
    }

    public void setContent(JsonNode content) {
        this.content = content;
    }

    public ATResponseAssertion getAnd() {
        return and;
    }

    public void setAnd(ATResponseAssertion and) {
        this.and = and;
    }

}
