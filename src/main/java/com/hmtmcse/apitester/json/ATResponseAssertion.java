package com.hmtmcse.apitester.json;


import java.util.LinkedHashMap;

public class ATResponseAssertion {


    public LinkedHashMap<String, Object> equal;
    public LinkedHashMap<String, Object> notEqual;
    public LinkedHashMap<String, Object> lessThan;
    public LinkedHashMap<String, Object> lessThanEqual;
    public LinkedHashMap<String, Object> greaterThan;
    public LinkedHashMap<String, Object> greaterThanEqual;

    public LinkedHashMap<String, Object> getEqual() {
        return equal;
    }

    public void setEqual(LinkedHashMap<String, Object> equal) {
        this.equal = equal;
    }

    public LinkedHashMap<String, Object> getNotEqual() {
        return notEqual;
    }

    public void setNotEqual(LinkedHashMap<String, Object> notEqual) {
        this.notEqual = notEqual;
    }

    public LinkedHashMap<String, Object> getLessThan() {
        return lessThan;
    }

    public void setLessThan(LinkedHashMap<String, Object> lessThan) {
        this.lessThan = lessThan;
    }

    public LinkedHashMap<String, Object> getLessThanEqual() {
        return lessThanEqual;
    }

    public void setLessThanEqual(LinkedHashMap<String, Object> lessThanEqual) {
        this.lessThanEqual = lessThanEqual;
    }

    public LinkedHashMap<String, Object> getGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(LinkedHashMap<String, Object> greaterThan) {
        this.greaterThan = greaterThan;
    }

    public LinkedHashMap<String, Object> getGreaterThanEqual() {
        return greaterThanEqual;
    }

    public void setGreaterThanEqual(LinkedHashMap<String, Object> greaterThanEqual) {
        this.greaterThanEqual = greaterThanEqual;
    }
}
