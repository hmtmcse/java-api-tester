package com.hmtmcse.apitester.json;


import java.util.LinkedHashMap;

public class ATResponseAssertion {


    public LinkedHashMap<Object, Object> equal;
    public LinkedHashMap<Object, Object> notEqual;
    public LinkedHashMap<Object, Object> lessThan;
    public LinkedHashMap<Object, Object> lessThanEqual;
    public LinkedHashMap<Object, Object> greaterThan;
    public LinkedHashMap<Object, Object> greaterThanEqual;

    public LinkedHashMap<Object, Object> getEqual() {
        return equal;
    }

    public void setEqual(LinkedHashMap<Object, Object> equal) {
        this.equal = equal;
    }

    public LinkedHashMap<Object, Object> getNotEqual() {
        return notEqual;
    }

    public void setNotEqual(LinkedHashMap<Object, Object> notEqual) {
        this.notEqual = notEqual;
    }

    public LinkedHashMap<Object, Object> getLessThan() {
        return lessThan;
    }

    public void setLessThan(LinkedHashMap<Object, Object> lessThan) {
        this.lessThan = lessThan;
    }

    public LinkedHashMap<Object, Object> getLessThanEqual() {
        return lessThanEqual;
    }

    public void setLessThanEqual(LinkedHashMap<Object, Object> lessThanEqual) {
        this.lessThanEqual = lessThanEqual;
    }

    public LinkedHashMap<Object, Object> getGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(LinkedHashMap<Object, Object> greaterThan) {
        this.greaterThan = greaterThan;
    }

    public LinkedHashMap<Object, Object> getGreaterThanEqual() {
        return greaterThanEqual;
    }

    public void setGreaterThanEqual(LinkedHashMap<Object, Object> greaterThanEqual) {
        this.greaterThanEqual = greaterThanEqual;
    }
}
