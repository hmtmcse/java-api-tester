package com.hmtmcse.apitester;

import com.hmtmcse.common.HMTMConfigHolder;
import com.hmtmcse.hmutil.HMUtil;
import com.hmtmcse.file.FileExceptionHandler;
import com.hmtmcse.file.FileUtil;
import com.hmtmcse.http.HttpExceptionHandler;
import com.hmtmcse.http.HttpResponse;
import com.hmtmcse.http.HttpTool;

public class Main {

    public static void main(String[] args) {


        HMTMConfigHolder.isDebug = true;

        ATCasesProcessor atCasesProcessor = new ATCasesProcessor();
        atCasesProcessor.run("test-data");
        System.exit(0);


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
            HMUtil.print(httpResponse.getContent());
        } catch (HttpExceptionHandler httpExceptionHandler) {
            System.out.println(httpExceptionHandler.getMessage());
        }

    }
}
