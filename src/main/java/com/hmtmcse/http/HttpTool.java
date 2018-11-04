package com.hmtmcse.http;

import com.hmtmcse.http.data.HttpRequest;
import com.hmtmcse.http.data.HttpResponse;

import java.util.LinkedHashMap;
import java.util.Map;

public class HttpTool extends HttpRequest {

    private LinkedHashMap<String, Object> paramMap = null;


    public HttpTool addParam(String key, Object value) {
        if (paramMap == null){
            paramMap = new LinkedHashMap<>();
        }
        paramMap.put(key, value);
        return this;
    }

    public String getRequestParams() {
        if (this.params != null){
            return this.params;
        }
        if (paramMap != null){
            StringBuilder keyValue = new StringBuilder();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()){
                keyValue.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            return keyValue.substring(0, keyValue.length() - 1);
        }
        return null;
    }


    public HttpTool post(String url) {
        httpMethod = POST;
        this.url = url;
        return this;
    }

    public HttpTool jsonPost(String url, String jsonString) {
        contextType = APPLICATION_JSON;
        httpMethod = POST;
        params = jsonString;
        this.url = url;
        return this;
    }

    public HttpTool download() {
        return this;
    }

    public HttpTool postDownload() {
        return this;
    }

    public HttpTool putDownload() {
        return this;
    }

    public HttpTool get(String url) {
        this.url = url;
        return this;
    }

    public HttpTool put() {
        return this;
    }

    public HttpTool jsonPut() {
        return this;
    }

    public HttpTool delete() {
        return this;
    }

    public HttpTool jsonDelete() {
        return this;
    }

    public HttpTool deletePost() {
        return this;
    }


    public HttpResponse send() throws HttpExceptionHandler {
        HttpManager httpManager = new HttpManager();
        this.params = getRequestParams();
        return httpManager.requestTo(this);
    }

    public static HttpTool instance() {
        return new HttpTool();
    }
}
