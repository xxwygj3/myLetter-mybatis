package com.ixygj.myletter.demo;

import com.ixygj.myletter.entity.LetterNumber;
import com.ixygj.myletter.entity.LetterNumberEndwise;
import com.ixygj.myletter.test.LetterNumberEndwiseMapperTest;
import com.ixygj.myletter.test.LetterNumberMapperTest;

import java.util.*;

//最近6期分析
public class LastSixIssueDemo {

    public static void main(String[] args) {
        System.out.println("===============查询数据 开始=======================");
        //查询 最近6期 letterNumber list
        List<LetterNumber> letterNumberList = LetterNumberMapperTest.selectLastSixIssueList();
        System.out.println(letterNumberList.toString());
        //第一位至第六位 list
        ArrayList<ArrayList<String>> numbersListList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 7; i++) {
            numbersListList.add(new ArrayList<String>());
        }
        for (LetterNumber letterNumber : letterNumberList) {
            String numbers = letterNumber.getNumbers();
            System.out.println(numbers);
            for (int i = 0; i < 7; i++) {
                numbersListList.get(i).add(numbers.substring(i, i + 1));
            }
        }
        System.out.println(numbersListList.toString());
        String numbersStr = null;
        String newnumbersStr = null;
        String replacenewnumbersStr = null;
        //生成新的70组数据
        Map<String,Integer> newnumbersLinkHashMap = new LinkedHashMap<>();
        for (ArrayList<String> numbersList : numbersListList) {
            for (int i = 0; i < 10; i++) {
                ArrayList<String> newnumbersList = new ArrayList<>();
                //System.out.println(numbersList.toString());
                newnumbersList.addAll(numbersList);
                newnumbersList.add(String.valueOf(i));
                numbersStr = newnumbersList.toString();
                System.out.println(numbersStr);
                //去掉[]
                newnumbersStr = numbersStr.substring(1, numbersStr.length() - 1);
                replacenewnumbersStr = newnumbersStr.replaceAll(",", "").replaceAll(" ", "");
                System.out.println(replacenewnumbersStr);//7位字符串
                newnumbersLinkHashMap.put(replacenewnumbersStr,0);
            }
        }

        System.out.println(newnumbersLinkHashMap.toString());

        System.out.println("===============查询历史开奖数据 开始=======================");
        //查询历史开奖数据 letterNumber list
        List<LetterNumber> letterNumbersList = LetterNumberMapperTest.selectList();
        ArrayList<String> numbersList = new ArrayList<>();
        for(LetterNumber number:letterNumbersList){
            numbersList.add(number.getNumbers());
        }
        System.out.println(numbersList.toString());
        System.out.println("===============查询历史开奖数据 结束=======================");

        System.out.println("===============查询历史纵向数据 开始=======================");
        //查询历史 letterNumberEndwise list
        List<LetterNumberEndwise> letterNumberEndwiseList = LetterNumberEndwiseMapperTest.selectLetterNumberEndwiseList();
        ArrayList<String> endwiseNumbersList = new ArrayList<>();
        for(LetterNumberEndwise endwise:letterNumberEndwiseList){
            endwiseNumbersList.add(endwise.getEndwiseNumbers());
        }
        System.out.println(endwiseNumbersList.toString());
        System.out.println("===============查询历史纵向数据 结束=======================");

        for(Map.Entry<String,Integer> newnumbers:newnumbersLinkHashMap.entrySet()){
//            //是否存在历史开奖数据
//            if (numbersList.contains(newnumbers.getKey())) {
//                newnumbers.setValue(1);
//            }
            //是否存在历史纵向数据
            if (endwiseNumbersList.contains(newnumbers.getKey())) {
                newnumbers.setValue(1);
            }
        }

        System.out.println(newnumbersLinkHashMap.toString());
        //要符合0000000模型
        int i=1;
        for(Map.Entry<String,Integer> newnumbers:newnumbersLinkHashMap.entrySet()){
            if(1 == newnumbers.getValue()){
                //System.out.println(newnumbers.getKey() + "," + newnumbers.getValue());
                System.out.println("第"+(i++)+"位删除"+newnumbers.getKey().substring(6));
            }
        }
        System.out.println("===============查询数据 结束=======================");

    }
}
