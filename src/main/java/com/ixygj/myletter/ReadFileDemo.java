package com.ixygj.myletter;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.ixygj.myletter.MyLotterDemo.sortMapByKey;

public class ReadFileDemo {

    //文件所在路径
    private static String path = "src/main/resources/MyLotter_number1_to_number7.txt";

    public static void main(String[] args) {
        //第一位至第七位 list
        ArrayList<String> numbersList = new ArrayList<String>();

        //从字符输入流中读取文本并缓冲字符
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            String line = "";
            //int i=0;
            //此种方式不会产生null
            while ((line = bufferedReader.readLine()) != null) {
                //每次装入一行
                //此种方式会产生null
                numbersList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != bufferedReader){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        for(String numbers:numbersList){
            System.out.println(numbers);
            //字符串拆分 每7个字符
            int length = numbers.length();
            System.out.println("length="+length);
            for(int i =0;i< length-6;i++){
                String number = numbers.substring(i,i+7);
                System.out.println(number);
                if(linkedHashMap.containsKey(number)){
                    linkedHashMap.put(number,linkedHashMap.get(number)+1);
                }else{
                    linkedHashMap.put(number,1);
                }
            }
        }

        //排序
        Map<String, Integer> linkedHashMapByKey = sortMapByKey(linkedHashMap);
        //遍历
        for (Map.Entry<String, Integer> map : linkedHashMapByKey.entrySet()) {
            System.out.println(map.getKey() + "," + map.getValue());
        }
    }


}
