package com.hmtmcse.apitester;

import com.hmtmcse.common.HMTMConfigHolder;

public class Main {

    public static void main(String[] args) {


        HMTMConfigHolder.isDebug = true;

        ATCasesProcessor atCasesProcessor = new ATCasesProcessor();
        atCasesProcessor.run("W:\\codes\\jira-task-manager\\api-test-json");
        System.exit(0);
    }
}
