package com.ixygj.myletter;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 页面下载工具类
 */
public class HttpUtils {
    private static final String URL = "https://kaijiang.500.com/static/info/kaijiang/xml/zj6j1/list.xml";

    private static String getPageContent(String url) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;
        String content = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            content = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void main(String[] args) {
        //开始数据库连接
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        LetterNumberMapper letterNumberMapper = sqlSession.getMapper(LetterNumberMapper.class);
        String maxIssue = letterNumberMapper.selectMaxIssue();
        System.out.println(maxIssue);//17154

        //封装list
        List<LetterNumber> letterNumberList = getLetterNumberList(maxIssue);
        //System.out.println(letterNumberList.toString());
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

    //组合number getNumber("5,2,8,2,9,8|4");
    private static String getNumber(String opencode){
        String number = "";
        StringBuffer stringBuffer = new StringBuffer();
        //根据,拆分成数组
        String[] codeArray = opencode.split(",");
        //System.out.println(Arrays.toString(codeArray));//[5, 2, 8, 2, 9, 8|4]
        for(int i=0;i < codeArray.length; i++){
            if(i < 5){
                stringBuffer.append(codeArray[i]);
            }else if(i==5){
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

    //封装list
    private static List<LetterNumber> getLetterNumberList(String maxIssue){
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
            String issue="";
            String number="";
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
                System.out.print(",key "+rowAttributes.item(0).getNodeValue());//19070
                //System.out.println(rowAttributes.item(1).getNodeName());//opencode
                System.out.print(" and value "+rowAttributes.item(1).getNodeValue());//5,2,8,2,9,8|4
                //System.out.println(rowAttributes.item(2).getNodeName());//opentime
                //System.out.println(rowAttributes.item(2).getNodeValue());//2019-06-18 00:00:00

                issue = rowAttributes.item(0).getNodeValue();
                number = getNumber(rowAttributes.item(1).getNodeValue());
                System.out.println("期号："+issue+" ,开奖号码："+number);
                if(maxIssue.equals(issue)){
                    System.out.println("===退出循环，当前期号："+issue+" ,数据库当前最大期号："+maxIssue+"===");
                    return list;
                }
                LetterNumber letterNumber = new LetterNumber(issue,number,number.toCharArray());
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
}
