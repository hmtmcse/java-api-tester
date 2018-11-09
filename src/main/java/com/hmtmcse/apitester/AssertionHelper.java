package com.hmtmcse.apitester;

public class AssertionHelper<T extends Comparable<T>> {

    public T userDefineValue;
    public T apiResponseValue;

    public Boolean isEqual(){
        int compare = apiResponseValue.compareTo(userDefineValue);
        if (compare == 0){
            return true;
        }else {
            return false;
        }
    }


    public Boolean notEqual(){
        int compare = apiResponseValue.compareTo(userDefineValue);
        if (compare == 0){
            return false;
        }else {
            return true;
        }
    }


    public Boolean lessThan(){
        int compare = apiResponseValue.compareTo(userDefineValue);
        if (compare < 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean lessThanEqual(){
        int compare = apiResponseValue.compareTo(userDefineValue);
        if (compare == 0) {
            return true;
        }else if (compare < 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean greaterThan(){
        int compare = apiResponseValue.compareTo(userDefineValue);
        if (compare > 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean greaterThanEqual(){
        int compare = apiResponseValue.compareTo(userDefineValue);
        if (compare == 0) {
            return true;
        }else if (compare > 0){
            return true;
        }else {
            return false;
        }
    }
}
