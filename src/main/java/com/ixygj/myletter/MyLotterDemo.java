package com.ixygj.myletter;

import org.apache.ibatis.session.SqlSession;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyLotterDemo {
    //文件所在路径
    private static String path = "C:\\Users/evcar.com/Downloads/Fish-v328/Fish-v328/kpdf/MyLotter_99_to_2017.csv";

    public static void main(String[] args) throws Exception {
        //开始数据库连接
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        LetterNumberMapper letterNumberMapper = sqlSession.getMapper(LetterNumberMapper.class);

        //主要业务
        //读取文件
        String issueNumbers = readFile();
        //封装list
        List<LetterNumber> letterNumberList = getList(issueNumbers);
        int i=0;
        for(LetterNumber letterNumber:letterNumberList){
            //新增记录
            int result = letterNumberMapper.insertLetterNumber(letterNumber);
            if (result > 0) {
                sqlSession.commit();
                System.out.println("第"+(i++)+"条记录,添加成功"+letterNumber.toString());
            } else {
                sqlSession.rollback();
            }
        }

        //结束数据库连接
        MyBatisUtils.closeSession(sqlSession);
    }

    //封装list
    private static List<LetterNumber> getList(String issueNumbers){
        List<LetterNumber> list = new ArrayList<>();
        //根据,拆分成数组
        String[] issueNumbersArray = issueNumbers.split(",");

        for(String issueNumber:issueNumbersArray){
            System.out.println(issueNumber);
            String[] issueNumberArray = issueNumber.split("  ");
            int i=0;
            StringBuffer buffer = new StringBuffer();
            String issue="";
            String number="";
            for(String str:issueNumberArray) {
                if(str == null){
                    break;
                }
                if (i == 0) {
                    issue = str;
                } else {
                    //去除前后空格
                    String temp = str.trim();
                    if(!"+".equals(temp)){
                        buffer.append(str.trim());
                    }
                }
                i++;
            }
            if(issue != null){
                number = buffer.toString();
                System.out.println("期号："+issue+" ,开奖号码："+number);

                LetterNumber letterNumber = new LetterNumber(issue,number,number.toCharArray());
                System.out.println(letterNumber.toString());
                list.add(letterNumber);
            }
        }
        return list;
    }

    //读取文件
    private static String readFile()throws Exception{
        //从字符输入流中读取文本并缓冲字符
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
        StringBuffer stringBuffer = new StringBuffer();
        String line="";
        //int i=0;
        //此种方式不会产生null
        while ((line = bufferedReader.readLine()) != null){
            //每次装入一行
            //此种方式会产生null
            //line = bufferedReader.readLine();
            stringBuffer.append(line);
            stringBuffer.append(",");
        }
        bufferedReader.close();
        return stringBuffer.substring(0,stringBuffer.length()-1).toString();
    }
}
