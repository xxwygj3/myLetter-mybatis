package com.ixygj.myletter.demo;

import com.ixygj.myletter.entity.LetterNumber;
import com.ixygj.myletter.entity.LetterNumberSub;
import com.ixygj.myletter.test.LetterNumberMapperTest;
import com.ixygj.myletter.test.LetterNumberSubMapperTest;

import java.io.*;
import java.util.*;

//第四步：已开奖数据的子串（2位~6位）统计分析
public class SubDemo {
    //文件所在路径
    private static final String OUTPUTPATH = "src/main/resources/MyLotter_sub_str.txt";

    public static void main(String[] args) {
        System.out.println("===============查询数据 开始=======================");
        //查询list
        List<LetterNumber> letterNumberStrs = LetterNumberMapperTest.selectList();
        System.out.println("===============查询数据 结束=======================");

        ArrayList<String> subList = new ArrayList<String>();
        int i = 0;
        for (LetterNumber letterNumber : letterNumberStrs) {
            System.out.println("第" + (i++) + "条记录,读取成功" + letterNumber.toString());

            String substr = letterNumber.getAllSubNumbersList();
            //去掉[]
            String newsubstr = substr.substring(1,substr.length()-1);
            String[] newsubstrArr = newsubstr.split(",");
            //System.out.println(Arrays.toString(newsubstrArr));
            subList.addAll(Arrays.asList(newsubstrArr));
            //System.out.println(subList.size());

        }

        System.out.println("===============保存数据到txt文件中 开始=======================");
        String substr = subList.toString();
        String newsubstr = substr.substring(1,substr.length()-1);
        //subList输出到txt文件中
        //从字符输入流中读取文本并缓冲字符
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(OUTPUTPATH))));
            String replacenewsubstr = newsubstr.replaceAll(",","\r\n").replaceAll(" ","");
            bufferedWriter.write(replacenewsubstr);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != bufferedWriter){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("===============保存数据到txt文件中 结束=======================");

        System.out.println("===============保存统计子串结果到数据库中 开始=======================");
        Map<String, Integer> submap = new HashMap<String, Integer>();
        for(String sub:subList){
            if(submap.containsKey(sub)){
                submap.put(sub,submap.get(sub)+1);
            }else{
                submap.put(sub,1);
            }
        }
        List<LetterNumberSub> letterNumberSubList = getLetterNumberSubList(submap);
        //LetterNumberSubMapperTest.insertLetterNumberSubList(letterNumberSubList);
        LetterNumberSubMapperTest.insertForeachLetterNumberSub(letterNumberSubList);
        System.out.println("===============保存统计子串结果到数据库中 结束=======================");
    }

    //封装sub list
    private static List<LetterNumberSub> getLetterNumberSubList(Map<String, Integer> submap){
        List<LetterNumberSub> list = new ArrayList<>();
        for (Map.Entry<String, Integer> sub : submap.entrySet()) {
            list.add(new LetterNumberSub(sub.getKey(),sub.getValue()));
        }
        return list;
    }
}
