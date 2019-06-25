package com.ixygj.myletter.demo;

import com.ixygj.myletter.entity.LetterNumberSum;
import com.ixygj.myletter.test.LetterNumberSumMapperTest;

import java.util.ArrayList;

public class FindSumValueDemo {
    public static void main(String[] args) {
        System.out.println("===============查询数据 开始=======================");
        //检查每位应排除的数字
        ArrayList<String> notNumberList = new ArrayList<>();
        notNumberList.add("3");
        notNumberList.add("8");
        notNumberList.add("5");
        notNumberList.add("5");
        notNumberList.add("1");
        notNumberList.add("5");
        notNumberList.add("6");

        ArrayList<String> resultList = new ArrayList<>();
        LetterNumberSum letterNumberSum = LetterNumberSumMapperTest.selectLetterNumberSumBysumValue("40");
        String NotLetterNumbersListStr = letterNumberSum.getNotLetterNumbersList().toString();
        //去掉[]
        String newsumValueStr = NotLetterNumbersListStr.substring(1, NotLetterNumbersListStr.length() - 1);
        String replacenewsumValueStr = newsumValueStr.replaceAll(" ", "");
        String[] notLetterNumbersArr=replacenewsumValueStr.split(",");
        System.out.println(notLetterNumbersArr.length);
        for(String notLetterNumbers:notLetterNumbersArr){
            //System.out.println(notLetterNumbers);

            ArrayList<String> notLetterNumberList = new ArrayList<>();
            for(int i=0;i<7;i++){
                notLetterNumberList.add(notLetterNumbers.substring(i, i + 1));
            }
            //System.out.println(notLetterNumberList.toString());
            int flag=1;
            for(int ii=0;ii<7;ii++){
                //如果存在则跳过
                if(notNumberList.get(ii).equals(notLetterNumberList.get(ii))){
                    flag=0;
                }
            }
            if(flag == 1){
                resultList.add(notLetterNumbers);
            }
        }
        System.out.println(resultList.size());
        for(String result:resultList){
            //以7打头
            if("7".equals(result.substring(0,1))&&"3".equals(result.substring(3,4))&&"5".equals(result.substring(6))){
                if(!"7".equals(result.substring(1,2))&&!"3".equals(result.substring(1,2))&&!"5".equals(result.substring(1,2))){
                    if(!"7".equals(result.substring(2,3))&&!"3".equals(result.substring(2,3))&&!"5".equals(result.substring(2,3))) {
                        if(!"7".equals(result.substring(5,6))&&!"3".equals(result.substring(5,6))&&!"5".equals(result.substring(5,6))) {
                            System.out.println(result);
                        }
                    }
                }
            }
        }
        System.out.println("===============查询数据 结束=======================");
    }
}
