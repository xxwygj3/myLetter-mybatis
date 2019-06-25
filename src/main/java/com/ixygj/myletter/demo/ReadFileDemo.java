package com.ixygj.myletter.demo;

import com.ixygj.myletter.entity.LetterNumber;
import com.ixygj.myletter.test.LetterNumberMapperTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadFileDemo {
    public static void main(String[] args) {
        System.out.println("===============查询历史开奖数据 开始=======================");
        //查询历史开奖数据 letterNumber list
        List<LetterNumber> letterNumberList = LetterNumberMapperTest.selectList();
        System.out.println(letterNumberList.size());
        ArrayList<String> numbersList = new ArrayList<>();
        for(LetterNumber number:letterNumberList){
            numbersList.add(number.getNumbers());
        }
        System.out.println(numbersList.size());
        System.out.println("===============查询历史开奖数据 结束=======================");

        Map<String,Integer> nubmersLinkedHashMap = new LinkedHashMap<>();

        String[] a1 = new String[]{"3", "7"};
        String[] a2 = new String[]{"8", "2"};
        String[] a3 = new String[]{"5", "1"};
        String[] a4 = new String[]{"5", "3"};
        String[] a5 = new String[]{"1", "9"};
        String[] a6 = new String[]{"5"};
        String[] a7 = new String[]{"6", "9"};
        for (String aa1 : a1) {
            for (String aa2 : a2) {
                for (String aa3 : a3) {
                    for (String aa4 : a4) {
                        for (String aa5 : a5) {
                            for (String aa6 : a6) {
                                for (String aa7 : a7) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append(aa1)
                                            .append(aa2)
                                            .append(aa3)
                                            .append(aa4)
                                            .append(aa5)
                                            .append(aa6)
                                            .append(aa7);
                                    System.out.println(stringBuffer.toString());
                                    nubmersLinkedHashMap.put(stringBuffer.toString(),0);
                                }
                            }
                        }
                    }
                }
            }
        }

        for(Map.Entry<String,Integer> nubmers:nubmersLinkedHashMap.entrySet()){
            if(numbersList.contains(nubmers.getKey())){
                nubmers.setValue(1);
            }
        }

        for(Map.Entry<String,Integer> nubmers:nubmersLinkedHashMap.entrySet()){
            System.out.println(nubmers.getKey()+","+nubmers.getValue());
        }
    }
}
