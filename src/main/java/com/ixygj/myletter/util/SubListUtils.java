package com.ixygj.myletter.util;

import java.util.ArrayList;
import java.util.List;

public class SubListUtils {
    //所有子串list
    public static List<String> getAllSubList(String str){
        List<String> subList = new ArrayList<String>();
        //String str = "1234567";
        //2位子串
        for(int i =0;i< 6;i++){
            subList.add(str.substring(i,i+2));
        }
        //3位子串
        for(int i =0;i< 5;i++){
            subList.add(str.substring(i,i+3));
        }
        //4位子串
        for(int i =0;i< 4;i++){
            subList.add(str.substring(i,i+4));
        }
        //5位子串
        for(int i =0;i< 3;i++){
            subList.add(str.substring(i,i+5));
        }
        //6位子串
        for(int i =0;i< 2;i++){
            subList.add(str.substring(i,i+6));
        }
        return subList;
    }
}
