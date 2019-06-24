package com.ixygj.myletter;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;

public class MyLotterDemo {
    //文件所在路径
    private static String path = "src/main/resources/MyLotter_99_to_2017.csv";
    //文件所在路径
    private static String outpath = "src/main/resources/MyLotter_sub_str.txt";
    //文件所在路径
    private static String outNumber1ToNumber7path = "src/main/resources/MyLotter_number1_to_number7.txt";
    //在线URL
    private static final String URL = "https://kaijiang.500.com/static/info/kaijiang/xml/zj6j1/list.xml";

    public static void main(String[] args) throws Exception {
//        System.out.println("===============离线数据处理 开始=======================");
//        //读取文件
//        String issueNumbers = readFile();
//        //封装list
//        List<LetterNumber> offlineLetterNumberList = getOfflineList(issueNumbers);
//        MapperUtils.insertLetterNumberList(offlineLetterNumberList);
//        System.out.println("===============离线数据处理 结束=======================");
//
//        System.out.println("===============在线数据处理 开始=======================");
//        //获取当前最大离线期号
//        String maxIssue = MapperUtils.selectMaxIssue();
//        //封装list
//        List<LetterNumber> onlineLetterNumberList = getOnlineList(maxIssue);
//        MapperUtils.insertLetterNumberList(onlineLetterNumberList);
//        System.out.println("===============在线数据处理 结束=======================");

        System.out.println("===============查询数据 开始=======================");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        //查询list
        List<LetterNumber> letterNumberStrs = MapperUtils.selectList();

//        Map<Integer, ArrayList<String>> sumListMap = new LinkedHashMap<Integer, ArrayList<String>>();
//        for (int i = 0; i < 64; i++) {
//            sumListMap.put(i, new ArrayList<String>());
//        }

        ArrayList<String> subList = new ArrayList<String>();
        //第一位至第七位 list
        ArrayList<ArrayList<String>> numberLists = new ArrayList<ArrayList<String>>();
        for(int i=0;i<7;i++){
            numberLists.add(new ArrayList<String>());
        }

        int i = 0;
        for (LetterNumber letterNumber : letterNumberStrs) {
            System.out.println("第" + (i++) + "条记录,读取成功" + letterNumber.toString());
            numberLists.get(0).add(letterNumber.getNumber1());
            numberLists.get(1).add(letterNumber.getNumber2());
            numberLists.get(2).add(letterNumber.getNumber3());
            numberLists.get(3).add(letterNumber.getNumber4());
            numberLists.get(4).add(letterNumber.getNumber5());
            numberLists.get(5).add(letterNumber.getNumber6());
            numberLists.get(6).add(letterNumber.getNumber7());
//            String substr = letterNumber.getAllSubNumbersList();
//            //去掉[]
//            String newsubstr = substr.substring(1,substr.length()-1);
//            String[] newsubstrArr = newsubstr.split(",");
//            System.out.println(Arrays.toString(newsubstrArr));
//            subList.addAll(Arrays.asList(newsubstrArr));
//            System.out.println(subList.size());
//            String key = letterNumber.getNumbers();
//            int sumKey = letterNumber.getSumValue();
//            //对应的sum key 放入list
//            sumListMap.get(sumKey).add(key);
//            sumListMap.put(sumKey, sumListMap.get(sumKey));
//
//            if (linkedHashMap.containsKey(key)) {
//                linkedHashMap.put(key, linkedHashMap.get(key) + 1);
//            } else {
//                linkedHashMap.put(key, 1);
//            }
        }

//        String substr = subList.toString();
//        String newsubstr = substr.substring(1,substr.length()-1);

//        System.out.println("===============保存数据到txt文件中 开始=======================");
//        //subList输出到txt文件中
//        //从字符输入流中读取文本并缓冲字符
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outpath))));
//        String replacenewsubstr = newsubstr.replaceAll(",","\r\n").replaceAll(" ","");
//        bufferedWriter.write(replacenewsubstr);
//        bufferedWriter.close();
//        System.out.println("===============保存数据到txt文件中 结束=======================");

//        System.out.println("===============保存统计子串结果 开始=======================");
//        Map<String, Integer> submap = new HashMap<String, Integer>();
//        String[]  newsubstrArr = newsubstr.split(",");
//        for(String sub:newsubstrArr){
//            if(submap.containsKey(sub)){
//                submap.put(sub,submap.get(sub)+1);
//            }else{
//                submap.put(sub,1);
//            }
//        }
//        List<LetterNumberSub> letterNumberSubList = getLetterNumberSubList(submap);
//        MapperUtils.insertLetterNumberSubList(letterNumberSubList);
//        System.out.println("===============保存统计子串结果 结束=======================");

//        //排序
//        Map<String,Integer> submapByKey = sortMapByKey(submap);
//        for(Map.Entry<String, Integer> map:submapByKey.entrySet()){
//            System.out.println(map.getKey() + "," + map.getValue());
//        }

//        //和值对应的所有7位字符串
//        Map<String, ArrayList<String>> allNumberslist = getAllNumbersList();
//        //遍历
//        for (Map.Entry<String, ArrayList<String>> numbers : allNumberslist.entrySet()) {
//            //System.out.println(numbers.getKey() + "," + numbers.getValue().toString());
//            System.out.println(numbers.getKey() + ","+numbers.getValue().size());
//        }
//
//        List<LetterNumberSum> letterNumberSumList = getLetterNumberSumList(sumListMap, allNumberslist);
//
//        MapperUtils.insertLetterNumberSumList(letterNumberSumList);
//
//        //排序
//        Map<String,Integer> linkedHashMapByKey = sortMapByKey(linkedHashMap);
//        //遍历
//        for (Map.Entry<String, Integer> map : linkedHashMapByKey.entrySet()) {
//            System.out.println(map.getKey() + "," + map.getValue());
//        }

        System.out.println("===============保存number1-7List数据到txt文件中 开始=======================");
        //subList输出到txt文件中
        //从字符输入流中读取文本并缓冲字符
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outNumber1ToNumber7path))));

        String number1To7str = null;
        String newnumber1To7str = null;
        String replacenewsubstr = null;
        for(int ii=0;ii<7;ii++){
            number1To7str = numberLists.get(ii).toString();
            //去掉[]
            newnumber1To7str = number1To7str.substring(1,number1To7str.length()-1);
            replacenewsubstr = newnumber1To7str.replaceAll(",","").replaceAll(" ","");
            bufferedWriter.write(replacenewsubstr);
            if(ii != 6){
                bufferedWriter.write("\r\n");
            }
        }
        bufferedWriter.close();
        System.out.println("===============保存number1-7List数据到txt文件中 结束=======================");

        System.out.println("===============查询数据 结束=======================");
    }

    //封装sum list
    private static List<LetterNumberSub> getLetterNumberSubList(Map<String, Integer> submap){
        List<LetterNumberSub> list = new ArrayList<>();
        for (Map.Entry<String, Integer> sub : submap.entrySet()) {
            list.add(new LetterNumberSub(sub.getKey(),sub.getValue()));
        }
        return list;
    }

    //所有子串list
    private static List<String> getAllSubList(String str){
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

    //各个位数之和
    private static String getIntSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return String.valueOf(sum);
    }

    //封装sum list
    private static List<LetterNumberSum> getLetterNumberSumList(Map<String, ArrayList<String>> sumListMap, Map<String, ArrayList<String>> allNumberslist) {
        List<LetterNumberSum> list = new ArrayList<>();
        ArrayList<String> notLetterList = null;
        for (Map.Entry<String, ArrayList<String>> sum : sumListMap.entrySet()) {
            //System.out.println(sum.getKey() + "," + sum.getValue().toString());
            //System.out.println(allNumberslist.get(sum.getKey()).size());
            notLetterList = new ArrayList<String>();
            notLetterList.addAll(allNumberslist.get(sum.getKey()));
            notLetterList.removeAll(sum.getValue());
            System.out.println(notLetterList.toString()+","+notLetterList.size());
            list.add(new LetterNumberSum(sum.getKey()
                    , sum.getValue().size()
                    , allNumberslist.get(sum.getKey()).size()
                    , notLetterList.size()
                    , sum.getValue().toString()
                    , allNumberslist.get(sum.getKey()).toString()
                    ,notLetterList.toString()));
        }
        for(Map.Entry<String, ArrayList<String>> all:allNumberslist.entrySet()){
            System.out.println(all.getKey() + "," + all.getValue().toString()+ "," + all.getValue().size());
        }
        return list;
    }

    //自定义排序方法，返回有序map
    public static Map<String, Integer> sortMapByKey(Map<String, Integer> linkedHashMap) {
        Map<String, Integer> treeMap = new TreeMap<>(new MapKeyComparator());
        treeMap.putAll(linkedHashMap);
        return treeMap;
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

    //封装在线list
    private static List<LetterNumber> getOnlineList(String maxIssue) {
        List<LetterNumber> list = new ArrayList<>();

        String content = HttpUtils.getPageContent(URL);
        System.out.println(content);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(content.getBytes());
            Document document = documentBuilder.parse(inputStream);
            NodeList rowList = document.getElementsByTagName("row");
            System.out.println("rowList长度：" + rowList.getLength());
            String issue = "";
            String numbers = "";
            for (int i = 0; i < rowList.getLength(); i++) {
                System.out.print("开始遍历第" + (i + 1) + "个row");
                Node row = rowList.item(i);
                NamedNodeMap rowAttributes = row.getAttributes();
                System.out.print(",共有" + rowAttributes.getLength() + "个属性");
                /*for (int j = 0; j < rowAttributes.getLength(); j++) {
                    Node attribute = rowAttributes.item(j);
                    System.out.print(",属性名：" + attribute.getNodeName());
                    System.out.print("对应 属性值：" + attribute.getNodeValue());
                    //开始遍历第1607个row,共有3个属性,属性名：expect对应 属性值：08001,属性名：opencode对应 属性值：1,7,8,2,2,4|6,属性名：opentime对应 属性值：2008-01-01 00:00:00
                    if("expect".equals(attribute.getNodeName())){
                        String expectValue = attribute.getNodeValue();
                    }
                    if("opencode".equals(attribute.getNodeName())){
                        String opencodeValue = attribute.getNodeValue();
                    }
                }*/
                //System.out.println(rowAttributes.item(0).getNodeName());//expect
                System.out.print(",key " + rowAttributes.item(0).getNodeValue());//19070
                //System.out.println(rowAttributes.item(1).getNodeName());//opencode
                System.out.print(" and value " + rowAttributes.item(1).getNodeValue());//5,2,8,2,9,8|4
                //System.out.println(rowAttributes.item(2).getNodeName());//opentime
                //System.out.println(rowAttributes.item(2).getNodeValue());//2019-06-18 00:00:00

                issue = rowAttributes.item(0).getNodeValue();
                numbers = getNumber(rowAttributes.item(1).getNodeValue());
                System.out.println("期号：" + issue + " ,开奖号码：" + numbers);
                if (maxIssue.equals(issue)) {
                    System.out.println("===退出循环，当前期号：" + issue + " ,数据库当前最大期号：" + maxIssue + "===");
                    return list;
                }
                //所有子串
                List<String> allSubNumbersList = getAllSubList(numbers);
                LetterNumber letterNumber = new LetterNumber(issue, numbers,allSubNumbersList.toString());
                System.out.println(letterNumber.toString());
                list.add(letterNumber);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //组合number getNumber("5,2,8,2,9,8|4");
    private static String getNumber(String opencode) {
        String number = "";
        StringBuffer stringBuffer = new StringBuffer();
        //根据,拆分成数组
        String[] codeArray = opencode.split(",");
        //System.out.println(Arrays.toString(codeArray));//[5, 2, 8, 2, 9, 8|4]
        for (int i = 0; i < codeArray.length; i++) {
            if (i < 5) {
                stringBuffer.append(codeArray[i]);
            } else if (i == 5) {
                String[] code2Array = codeArray[5].split("\\|");
                //System.out.println(Arrays.toString(code2Array));//[8, 4]
                stringBuffer.append(code2Array[0]);
                stringBuffer.append(code2Array[1]);
            }
        }
        number = stringBuffer.toString();
        //System.out.println(number);
        return number;
    }

    //读取文件
    private static String readFile() throws Exception {
        //从字符输入流中读取文本并缓冲字符
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
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

}
