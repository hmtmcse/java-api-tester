package com.hmtmcse.http;

import com.hmtmcse.common.HMTMUtil;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;


public class HttpManager {

    private final String INVALID_URL = "Invalid URL OR Server Down!";
    private final String URL_ERROR = "URL Not found.";
    private final String TIME_OUT = "Connection TimeOut!";

    private String handleUrlRedirection(String url) throws IOException {
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        int status = httpURLConnection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_SEE_OTHER) {
                return httpURLConnection.getHeaderField("Location");
            }
        }
        return url;
    }


    private String streamToText(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }


    private Boolean streamToFile(String path, Integer bufferSize, InputStream inputStream) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        int bytesRead = -1;
        byte[] buffer = new byte[bufferSize];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        return true;
    }

    private void validateRequest(HttpRequest httpRequest) throws HttpExceptionHandler {
        if (httpRequest.url == null || httpRequest.url.equals("")){
            throw new HttpExceptionHandler(URL_ERROR);
        }
    }


    public HttpResponse requestTo(HttpRequest httpRequest) throws HttpExceptionHandler {
        HttpResponse httpResponse = new HttpResponse();
        try {
            validateRequest(httpRequest);

            if (httpRequest.isEnableRedirectHandle) {
                httpRequest.url = handleUrlRedirection(httpRequest.url);
            }

            URL httpUrl = new URL(httpRequest.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
            httpURLConnection.setReadTimeout(httpRequest.connectionTimeout);
            httpURLConnection.setRequestProperty("Content-Type", httpRequest.contextType);
            httpURLConnection.setRequestProperty("User-Agent", httpRequest.userAgent);

            for (RequestHeader requestHeader : httpRequest.headers) {
                httpURLConnection.setRequestProperty(requestHeader.key, requestHeader.value);
            }

            DataOutputStream dataOutputStream;
            switch (httpRequest.httpMethod) {
                case HttpRequest.POST:
                case HttpRequest.PUT:
                case HttpRequest.DELETE_POST:
                    httpURLConnection.setDoOutput(true);
                    dataOutputStream  = new DataOutputStream(httpURLConnection.getOutputStream());
                    if (httpRequest.httpMethod.equals(HttpRequest.DELETE_POST)){
                        httpURLConnection.setRequestMethod(HttpRequest.DELETE);
                    }else{
                        httpURLConnection.setRequestMethod(httpRequest.httpMethod);
                    }

                    if (httpRequest.params != null){
                        dataOutputStream.writeBytes(httpRequest.params);
                    }

                    dataOutputStream.flush();
                    dataOutputStream.close();
                    break;
                default:
                    httpURLConnection.setRequestMethod(httpRequest.httpMethod);
                    break;
            }

            httpResponse.setHttpCode(httpURLConnection.getResponseCode());
            if (httpResponse.getHttpCode() >= 200 && 300 > httpResponse.getHttpCode()) {
                if (!httpRequest.isDownload){
                    httpResponse.content = streamToText(httpURLConnection.getInputStream());
                }else if (httpRequest.isDownload && httpRequest.filePath != null){
                   if (httpRequest.fileName == null){
                       String fileName = httpURLConnection.getHeaderField("Content-Disposition");
                       int index = fileName.indexOf("filename=");
                       if (index > 0) {
                           httpRequest.fileName = fileName.substring(index + 10, fileName.length() - 1);
                       }else{
                           httpRequest.fileName = "download.dat";
                       }
                   }
                   streamToFile(HMTMUtil.concatLocation(httpRequest.filePath, httpRequest.fileName), httpRequest.fileBufferSize, httpURLConnection.getInputStream());
                }
            }else {
                httpResponse.content = streamToText(httpURLConnection.getErrorStream());
            }

        } catch (ConnectException c) {
            throw new HttpExceptionHandler(TIME_OUT + ". Message: " + c.getLocalizedMessage());
        } catch (SocketTimeoutException s) {
            throw new HttpExceptionHandler(INVALID_URL + ". Message: " + s.getLocalizedMessage());
        } catch (IOException e) {
            String message = "IOException " + e.getMessage();
            throw new HttpExceptionHandler(message);
        }
        return httpResponse;
    }
}
