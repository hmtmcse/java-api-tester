package com.hmtmcse.apitester.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ATTestCases {

    public static void xyz(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ATTestCase atTestCase = objectMapper.readValue(new File("doc/test.json"), ATTestCase.class);
            System.out.println("Xyz");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
