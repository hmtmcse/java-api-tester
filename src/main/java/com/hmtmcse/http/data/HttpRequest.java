package com.hmtmcse.http.data;

import java.util.ArrayList;
import java.util.List;

public class HttpRequest {

    public static final String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public final static String APPLICATION_JSON = "application/json";
    public static final String POST = "POST";
    public static final String GET = "GET";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String DELETE_POST = "DELETE_POST";

    public Integer connectionTimeout = 30000;
    public Integer fileBufferSize = 1024;
    public String userAgent = "HMTMCSE/1.0";

    public String httpMethod = GET;
    public String url = null;
    public String params = null;
    public String contextType = APPLICATION_FORM_URLENCODED;
    public List<RequestHeader> headers = new ArrayList<>();
    public Boolean isEnableRedirectHandle = true;
    public Boolean isDownload = false;
    public String fileName;
    public String filePath;

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getFileBufferSize() {
        return fileBufferSize;
    }

    public void setFileBufferSize(Integer fileBufferSize) {
        this.fileBufferSize = fileBufferSize;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public List<RequestHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<RequestHeader> headers) {
        this.headers = headers;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
