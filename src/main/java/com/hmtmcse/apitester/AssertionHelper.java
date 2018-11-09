package com.hmtmcse.apitester;

public class AssertionHelper<T extends Comparable<T>> {

    public T userDefineValue;
    public T apiResponseValue;

    public Boolean isEqual(){
        int compare = userDefineValue.compareTo(apiResponseValue);
        if (compare == 0){
            return true;
        }else {
            return false;
        }
    }


    public Boolean notEqual(){
        int compare = userDefineValue.compareTo(apiResponseValue);
        if (compare == 0){
            return false;
        }else {
            return true;
        }
    }


    public Boolean lessThan(){
        int compare = userDefineValue.compareTo(apiResponseValue);
        if (compare < 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean lessThanEqual(){
        int compare = userDefineValue.compareTo(apiResponseValue);
        if (compare == 0) {
            return true;
        }else if (compare < 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean greaterThan(){
        int compare = userDefineValue.compareTo(apiResponseValue);
        if (compare > 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean greaterThanEqual(){
        int compare = userDefineValue.compareTo(apiResponseValue);
        if (compare == 0) {
            return true;
        }else if (compare > 0){
            return true;
        }else {
            return false;
        }
    }
}
