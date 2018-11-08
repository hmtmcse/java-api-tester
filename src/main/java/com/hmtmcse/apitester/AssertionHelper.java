package com.hmtmcse.apitester;

public class AssertionHelper<T extends Comparable<T>> {

    public Boolean isEqual(T first, T second){
        if (first instanceof String){
            return first.equals(second);
        }
        return (first == second);
    }


    public Boolean notEqual(T first, T second){
        if (first instanceof String){
            return !first.equals(second);
        }
        return (first != second);
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
