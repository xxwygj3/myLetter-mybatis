package com.ixygj.myletter.demo;

import com.ixygj.myletter.entity.LetterNumber;
import com.ixygj.myletter.entity.LetterNumberEndwise;
import com.ixygj.myletter.test.LetterNumberEndwiseMapperTest;
import com.ixygj.myletter.test.LetterNumberMapperTest;
import com.ixygj.myletter.util.SortMap;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class From1To7Demo {
    //文件所在路径
    private static String OUTPUTPATH = "src/main/resources/MyLotter_number1_to_number7.txt";

    public static void main(String[] args) {
        System.out.println("===============查询数据 开始=======================");
        //查询list
        List<LetterNumber> letterNumberStrs = LetterNumberMapperTest.selectList();
        System.out.println("===============查询数据 结束=======================");

        //第一位至第七位 list
        ArrayList<ArrayList<String>> numbersListList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 7; i++) {
            numbersListList.add(new ArrayList<String>());
        }
        int i = 0;
        for (LetterNumber letterNumber : letterNumberStrs) {
            System.out.println("第" + (i++) + "条记录,读取成功" + letterNumber.toString());
            numbersListList.get(0).add(letterNumber.getNumber1());
            numbersListList.get(1).add(letterNumber.getNumber2());
            numbersListList.get(2).add(letterNumber.getNumber3());
            numbersListList.get(3).add(letterNumber.getNumber4());
            numbersListList.get(4).add(letterNumber.getNumber5());
            numbersListList.get(5).add(letterNumber.getNumber6());
            numbersListList.get(6).add(letterNumber.getNumber7());
        }

        System.out.println("===============保存number1-7List数据到txt文件中 开始=======================");
        //subList输出到txt文件中
        //从字符输入流中读取文本并缓冲字符
        BufferedWriter bufferedWriter = null;
        String number1To7str = null;
        String newnumber1To7str = null;
        String replacenewsubstr = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(OUTPUTPATH))));
            for (int ii = 0; ii < 7; ii++) {
                number1To7str = numbersListList.get(ii).toString();
                //去掉[]
                newnumber1To7str = number1To7str.substring(1, number1To7str.length() - 1);
                replacenewsubstr = newnumber1To7str.replaceAll(",", "").replaceAll(" ", "");
                bufferedWriter.write(replacenewsubstr);
                if (ii != 6) {
                    bufferedWriter.write("\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedWriter) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("===============保存number1-7List数据到txt文件中 结束=======================");

        System.out.println("===============保存number1-7List结果到数据库中 开始=======================");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        number1To7str = null;
        newnumber1To7str = null;
        replacenewsubstr = null;
        for (int ii = 0; ii < 7; ii++) {
            number1To7str = numbersListList.get(ii).toString();
            //去掉[]
            newnumber1To7str = number1To7str.substring(1, number1To7str.length() - 1);
            replacenewsubstr = newnumber1To7str.replaceAll(",", "").replaceAll(" ", "");
            System.out.println(replacenewsubstr);
            //字符串拆分 每7个字符
            int length = replacenewsubstr.length();
            System.out.println("length=" + length);
            String numbers = null;
            for (int iii = 0; iii < length - 6; iii++) {
                numbers = replacenewsubstr.substring(iii, iii + 7);
                System.out.println(numbers);
                if (linkedHashMap.containsKey(numbers)) {
                    linkedHashMap.put(numbers, linkedHashMap.get(numbers) + 1);
                } else {
                    linkedHashMap.put(numbers, 1);
                }
            }
        }

        //排序
        Map<String, Integer> linkedHashMapByKey = SortMap.sortMapByKey(linkedHashMap);
        for (Map.Entry<String, Integer> map : linkedHashMapByKey.entrySet()) {
            System.out.println(map.getKey() + "," + map.getValue());
        }
        List<LetterNumberEndwise> letterNumberEndwiseList = getLetterNumberEndwiseList(linkedHashMapByKey);
        LetterNumberEndwiseMapperTest.insertLetterNumberEndwiseList(letterNumberEndwiseList);
        System.out.println("===============保存number1-7List结果到数据库中 结束=======================");
    }

    //封装endwise list
    private static List<LetterNumberEndwise> getLetterNumberEndwiseList(Map<String, Integer> endwiseMap) {
        List<LetterNumberEndwise> list = new ArrayList<>();
        for (Map.Entry<String, Integer> endwise : endwiseMap.entrySet()) {
            list.add(new LetterNumberEndwise(endwise.getKey(), endwise.getValue()));
        }
        return list;
    }
}
