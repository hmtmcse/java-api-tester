package com.hmtmcse.apitester;

import com.hmtmcse.apitester.json.ATResponse;

public class APIResponseReport extends ATResponse {

    public Boolean isSuccess = false;
    public String name;
    public String url;
    public String method;
    public String response;
    public String requestContextType;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRequestContextType() {
        return requestContextType;
    }

    public void setRequestContextType(String requestContextType) {
        this.requestContextType = requestContextType;
    }
}
