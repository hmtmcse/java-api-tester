package com.hmtmcse.apitester;

import com.hmtmcse.apitester.json.ATTestCases;
import com.hmtmcse.common.HMTMConfigHolder;
import com.hmtmcse.common.HMTMUtil;
import com.hmtmcse.http.HttpExceptionHandler;
import com.hmtmcse.http.HttpResponse;
import com.hmtmcse.http.HttpTool;

public class Main {

    public static void main(String[] args) {

        ATTestCases.xyz();
        System.exit(0);

        try {
            HMTMConfigHolder.isDebug = true;
            HttpResponse httpResponse = HttpTool.instance()
                    .download("http://localhost/portal.zip", "C:\\Users\\touhid\\Desktop\\template\\download")
                    .send();
            HMTMUtil.print(httpResponse.getContent());
        } catch (HttpExceptionHandler httpExceptionHandler) {
            System.out.println(httpExceptionHandler.getMessage());
        }

    }
}
