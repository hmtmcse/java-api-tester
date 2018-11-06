package com.hmtmcse.apitester;

import com.hmtmcse.common.ATExceptionHandler;
import com.hmtmcse.file.FileExceptionHandler;
import com.hmtmcse.file.FileInfo;
import com.hmtmcse.file.FileUtil;
import java.util.List;



public class ATCasesProcessor {

    public void getTestCases(String location) throws ATExceptionHandler {
        try {
            List<FileInfo> fileInfos = FileUtil.listAllFile(location);
        } catch (FileExceptionHandler fileExceptionHandler) {
            throw new ATExceptionHandler(fileExceptionHandler.getMessage());
        }
    }

}
