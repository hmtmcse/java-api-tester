package com.hmtmcse.apitester;

import com.hmtmcse.common.HMTMConfigHolder;

public class Main {

    public static void main(String[] args) {


        HMTMConfigHolder.isDebug = true;

        ATCasesProcessor atCasesProcessor = new ATCasesProcessor();
        atCasesProcessor.run("test-data");
        System.exit(0);
    }
}
