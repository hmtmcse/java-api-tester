package com.hmtmcse.apitester;

import com.hmtmcse.common.HMTMConfigHolder;
import com.hmtmcse.common.HMTMUtil;
import com.hmtmcse.file.FileExceptionHandler;
import com.hmtmcse.file.FileUtil;
import com.hmtmcse.http.HttpExceptionHandler;
import com.hmtmcse.http.HttpResponse;
import com.hmtmcse.http.HttpTool;

public class Main {

    public static void main(String[] args) {

        try {
            FileUtil.print(FileUtil.listAll("C:\\Users\\hmtmc\\OneDrive\\Desktop\\templates\\files"));
        } catch (FileExceptionHandler fileExceptionHandler) {
            fileExceptionHandler.printStackTrace();
        }
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
