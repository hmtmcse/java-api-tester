package com.hmtmcse.apitester;

import com.hmtmcse.common.HMTMConfigHolder;
import com.hmtmcse.common.HMTMUtil;
import com.hmtmcse.http.HttpExceptionHandler;
import com.hmtmcse.http.HttpResponse;
import com.hmtmcse.http.HttpTool;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bismillah");

        try {
            HMTMConfigHolder.isDebug = true;
            HttpResponse httpResponse = HttpTool.instance()
                    .get("http://localhost:8080/api/v2/user/list?touhid=xyz mia&xyz=abc").addParam("oi", "touhid vai")
                    .send();
            HMTMUtil.print(httpResponse.getContent());
        } catch (HttpExceptionHandler httpExceptionHandler) {
            System.out.println(httpExceptionHandler.getMessage());
        }

    }
}
