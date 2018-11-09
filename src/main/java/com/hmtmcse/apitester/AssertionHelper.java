package com.hmtmcse.apitester;

public class AssertionHelper<T extends Comparable<T>> {

    public T userDefineValue;
    public T apiResponseValue;

    public Boolean isEqual(T first, T second){
        int compare = first.compareTo(second);
        if (compare == 0){
            return true;
        }else {
            return false;
        }
    }


    public Boolean notEqual(T first, T second){
        int compare = first.compareTo(second);
        if (compare == 0){
            return false;
        }else {
            return true;
        }
    }


    public Boolean lessThan(T first, T second){
        int compare = first.compareTo(second);
        if (compare < 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean lessThanEqual(T first, T second){
        int compare = first.compareTo(second);
        if (compare == 0) {
            return true;
        }else if (compare < 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean greaterThan(T first, T second){
        int compare = first.compareTo(second);
        if (compare > 0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean greaterThanEqual(T first, T second){
        int compare = first.compareTo(second);
        if (compare == 0) {
            return true;
        }else if (compare > 0){
            return true;
        }else {
            return false;
        }
    }
}
