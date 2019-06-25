package com.ixygj.myletter.demo;

import com.ixygj.myletter.entity.LetterNumber;
import com.ixygj.myletter.entity.LetterNumberSum;
import com.ixygj.myletter.test.LetterNumberMapperTest;
import com.ixygj.myletter.test.LetterNumberSumMapperTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//第三步：已开奖数据求和分析
public class SumDemo {

    public static void main(String[] args) {
        System.out.println("===============查询数据 开始=======================");
        //查询list
        List<LetterNumber> letterNumberStrs = LetterNumberMapperTest.selectList();
        System.out.println("===============查询数据 结束=======================");

        Map<Integer, ArrayList<String>> sumListMap = new LinkedHashMap<Integer, ArrayList<String>>();
        for (int i = 0; i < 64; i++) {
            sumListMap.put(i, new ArrayList<String>());
        }

        int i = 0;
        for (LetterNumber letterNumber : letterNumberStrs) {
            System.out.println("第" + (i++) + "条记录,读取成功" + letterNumber.toString());
            String key = letterNumber.getNumbers();
            int sumKey = letterNumber.getSumValue();
            //对应的sum key 放入list
            sumListMap.get(sumKey).add(key);
            sumListMap.put(sumKey, sumListMap.get(sumKey));
        }

        //和值对应的所有7位字符串
        Map<String, ArrayList<String>> allNumberslist = getAllNumbersList();
        //遍历
        for (Map.Entry<String, ArrayList<String>> numbers : allNumberslist.entrySet()) {
            //System.out.println(numbers.getKey() + "," + numbers.getValue().toString());
            System.out.println(numbers.getKey() + "," + numbers.getValue().size());
        }

        List<LetterNumberSum> letterNumberSumList = getLetterNumberSumList(sumListMap, allNumberslist);
        LetterNumberSumMapperTest.insertLetterNumberSumList(letterNumberSumList);
    }

    //封装sum list
    private static List<LetterNumberSum> getLetterNumberSumList(Map<Integer, ArrayList<String>> sumListMap, Map<String, ArrayList<String>> allNumberslist) {
        List<LetterNumberSum> list = new ArrayList<>();
        ArrayList<String> notLetterList = null;
        for (Map.Entry<Integer, ArrayList<String>> sum : sumListMap.entrySet()) {
            //System.out.println(sum.getKey() + "," + sum.getValue().toString());
            //System.out.println(allNumberslist.get(sum.getKey()).size());
            notLetterList = new ArrayList<String>();
            notLetterList.addAll(allNumberslist.get(sum.getKey().toString()));
            notLetterList.removeAll(sum.getValue());
            System.out.println(notLetterList.toString()+","+notLetterList.size());
            list.add(new LetterNumberSum(sum.getKey().toString()
                    , sum.getValue().size()
                    , allNumberslist.get(sum.getKey().toString()).size()
                    , notLetterList.size()
                    , sum.getValue().toString()
                    , allNumberslist.get(sum.getKey().toString()).toString()
                    ,notLetterList.toString()));
        }
        for(Map.Entry<String, ArrayList<String>> all:allNumberslist.entrySet()){
            System.out.println(all.getKey() + "," + all.getValue().toString()+ "," + all.getValue().size());
        }
        return list;
    }

    //所有号码列表
    private static Map<String, ArrayList<String>> getAllNumbersList() {
        Map<String, ArrayList<String>> allNumbersListMap = new LinkedHashMap<String, ArrayList<String>>();
        for (int i = 0; i < 64; i++) {
            allNumbersListMap.put(String.valueOf(i), new ArrayList<String>());
        }
        for (int i = 0; i <= 9999999; i++) {
            String sum = getIntSum(i);
            String sevenStr = getIntToSevenString(i);
            //对应的sum对应7位的数字 放入list
            allNumbersListMap.get(sum).add(sevenStr);
            allNumbersListMap.put(sum, allNumbersListMap.get(sum));
        }
        return allNumbersListMap;
    }

    //各个位数之和
    private static String getIntSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return String.valueOf(sum);
    }

    //数字转7位数字符串，高位补0
    private static String getIntToSevenString(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        String str = String.valueOf(num);
        switch (str.length()) {
            case 1:
                stringBuffer.append("000000").append(str);
                break;
            case 2:
                stringBuffer.append("00000").append(str);
                break;
            case 3:
                stringBuffer.append("0000").append(str);
                break;
            case 4:
                stringBuffer.append("000").append(str);
                break;
            case 5:
                stringBuffer.append("00").append(str);
                break;
            case 6:
                stringBuffer.append("0").append(str);
                break;
            case 7:
                stringBuffer.append(str);
                break;
            default:
        }
        return stringBuffer.toString();
    }
}
