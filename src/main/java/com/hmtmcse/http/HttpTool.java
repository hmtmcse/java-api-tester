package com.hmtmcse.http;

import java.net.URI;
import java.net.URISyntaxException;
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

    private String getRequestUrlWithParams(){
        if (this.url != null && this.params != null){
            try {
                URI uri = new URI(this.url);
                StringBuilder stringBuilder = new StringBuilder(uri.getQuery() == null ? "" : uri.getQuery());
                if (stringBuilder.length() > 0){
                    stringBuilder.append('&');
                }
                stringBuilder.append(this.params);
                URI newURI = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder.toString() , uri.getFragment());
                return newURI.toString();
            } catch (URISyntaxException e) {
                return this.url;
            }
        }
        return this.url;
    }


    public String getRequestParams() {
        if (this.params != null){
            return this.params;
        }
        if (paramMap != null){
            StringBuilder keyValue = new StringBuilder();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()){
                keyValue.append(entry.getKey()).append("=").append(urlEncode(entry.getValue().toString())).append("&");
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


    public HttpTool download(String url, String savedPath) {
        return download(url, savedPath, null);
    }


    public HttpTool download(String url, String savedPath, String fileName) {
        this.url = url;
        this.fileName = fileName;
        this.filePath = savedPath;
        this.isDownload = true;
        return this;
    }


    public HttpTool postDownload(String url, String savedPath, String fileName) {
        this.url = url;
        httpMethod = POST;
        this.fileName = fileName;
        this.filePath = savedPath;
        this.isDownload = true;
        return this;
    }



    public HttpTool putDownload(String url, String savedPath, String fileName) {
        this.url = url;
        httpMethod = PUT;
        this.fileName = fileName;
        this.filePath = savedPath;
        this.isDownload = true;
        return this;
    }


    public HttpTool get(String url) {
        this.url = url;
        return this;
    }

    public HttpTool addHeader(String key, String value) {
        this.headers.add(new RequestHeader(key, value));
        return this;
    }

    public HttpTool put(String url) {
        httpMethod = PUT;
        this.url = url;
        return this;
    }

    public HttpTool jsonPut(String url, String jsonString) {
        contextType = APPLICATION_JSON;
        httpMethod = PUT;
        params = jsonString;
        this.url = url;
        return this;
    }


    public HttpTool delete(String url) {
        httpMethod = DELETE;
        this.url = url;
        return this;
    }

    public HttpTool jsonDelete(String url, String jsonString) {
        contextType = APPLICATION_JSON;
        httpMethod = DELETE_POST;
        params = jsonString;
        this.url = url;
        return this;
    }

    public HttpTool deletePost(String url) {
        httpMethod = DELETE_POST;
        this.url = url;
        return this;
    }


    public HttpResponse send() throws HttpExceptionHandler {
        HttpManager httpManager = new HttpManager();
        this.params = getRequestParams();
        this.url = toURL(this.url);
        if (this.httpMethod.equals(GET)){
            this.url = getRequestUrlWithParams();
        }
        return httpManager.requestTo(this);
    }



    public static HttpTool instance() {
        return new HttpTool();
    }
}
