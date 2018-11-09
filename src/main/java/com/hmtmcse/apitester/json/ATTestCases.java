package com.hmtmcse.apitester.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmtmcse.hmutil.HMUtil;
import com.hmtmcse.file.FileExceptionHandler;
import com.hmtmcse.file.FileInfo;
import com.hmtmcse.file.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ATTestCases {

    public List<ATTestCase> processCase(List<FileInfo> fileInfoList, List<ATTestCase> cases){
        if (cases == null){
            cases = new ArrayList<>();
        }

        String extension;
        File testCaseFile; ATTestCase atTestCase;
        for (FileInfo fileInfo: fileInfoList){
            if (fileInfo.isDirectory){
                cases = processCase(fileInfo.getSubDirectories(), cases);
            }else{
                extension = fileInfo.getFileExtension();
                if (extension != null && !extension.equals("") && extension.toLowerCase().equals("json")){
                    testCaseFile = new File(fileInfo.getAbsolutePath());
                    if (testCaseFile.exists()){
                        ObjectMapper objectMapper = new ObjectMapper();
                        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        try {
                            atTestCase = objectMapper.readValue(testCaseFile, ATTestCase.class);
                            if (atTestCase != null){
                                cases.add(atTestCase);
                            }
                        } catch (IOException e) {
                            HMUtil.print(e.getMessage());
                        }
                    }
                }
            }
        }
        return cases;
    }



    public List<ATTestCase> getTestCases(String directoryLocation){
        List<ATTestCase> cases = new ArrayList<>();
        try {
            List<FileInfo> fileInfo = FileUtil.listAllFile(directoryLocation);
            cases = processCase(fileInfo, cases);
        } catch (FileExceptionHandler e) {
            HMUtil.print(e.getMessage());
        }
        return cases;
    }

}
