package com.hmtmcse.apitester.json;

import java.util.List;

public class ATTestCase {

    public String baseUrl;
    public String contextType = null;
    public List<ATRequest> requests = null;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public List<ATRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<ATRequest> requests) {
        this.requests = requests;
    }
}
