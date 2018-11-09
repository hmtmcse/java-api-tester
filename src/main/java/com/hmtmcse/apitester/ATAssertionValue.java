package com.hmtmcse.apitester;



public class ATAssertionValue<T> {

    public T apiValue;
    public T userDefineValue;


    public T getApiValue() {
        return apiValue;
    }

    public void setApiValue(T apiValue) {
        this.apiValue = apiValue;
    }

    public T getUserDefineValue() {
        return userDefineValue;
    }

    public void setUserDefineValue(T userDefineValue) {
        this.userDefineValue = userDefineValue;
    }
}
