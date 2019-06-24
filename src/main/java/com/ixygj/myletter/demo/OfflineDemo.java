package com.ixygj.myletter.demo;

import com.ixygj.myletter.entity.LetterNumber;
import com.ixygj.myletter.test.LetterNumberMapperTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.ixygj.myletter.util.SubListUtils.getAllSubList;

public class OfflineDemo {
    //文件所在路径
    private static final String INPUTPATH = "src/main/resources/MyLotter_99_to_2017.csv";

    public static void main(String[] args) throws Exception {
        System.out.println("===============离线数据处理 开始=======================");
        //读取文件
        String issueNumbers = readFile(INPUTPATH);
        //封装list
        List<LetterNumber> offlineLetterNumberList = getOfflineList(issueNumbers);
        LetterNumberMapperTest.insertLetterNumberList(offlineLetterNumberList);
        System.out.println("===============离线数据处理 结束=======================");
    }

    //读取文件
    private static String readFile(String inputPath) throws Exception {
        //从字符输入流中读取文本并缓冲字符
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputPath))));
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        //int i=0;
        //此种方式不会产生null
        while ((line = bufferedReader.readLine()) != null) {
            //每次装入一行
            //此种方式会产生null
            //line = bufferedReader.readLine();
            stringBuffer.append(line);
            stringBuffer.append(",");
        }
        bufferedReader.close();
        return stringBuffer.substring(0, stringBuffer.length() - 1).toString();
    }

    //封装离线list
    private static List<LetterNumber> getOfflineList(String issueNumbers) {
        List<LetterNumber> list = new ArrayList<>();
        //根据,拆分成数组
        String[] issueNumbersArray = issueNumbers.split(",");

        for (String issueNumber : issueNumbersArray) {
            System.out.println(issueNumber);
            String[] issueNumberArray = issueNumber.split("  ");
            int i = 0;
            StringBuffer buffer = new StringBuffer();
            String issue = "";
            String numbers = "";
            for (String str : issueNumberArray) {
                if (str == null) {
                    break;
                }
                if (i == 0) {
                    issue = str;
                } else {
                    //去除前后空格
                    String temp = str.trim();
                    if (!"+".equals(temp)) {
                        buffer.append(str.trim());
                    }
                }
                i++;
            }
            if (issue != null) {
                numbers = buffer.toString();
                System.out.println("期号：" + issue + " ,开奖号码：" + numbers);
                //所有子串
                List<String> allSubNumbersList = getAllSubList(numbers);
                LetterNumber letterNumber = new LetterNumber(issue, numbers,allSubNumbersList.toString());
                System.out.println(letterNumber.toString());
                list.add(letterNumber);
            }
        }
        return list;
    }

}
