package com.ixygj.myletter;

import org.apache.ibatis.session.SqlSession;

import java.util.*;
import java.util.Map.Entry;

public class Analysis {

    public static void main(String[] args) {
        //开始数据库连接
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        LetterNumberMapper letterNumberMapper = sqlSession.getMapper(LetterNumberMapper.class);

        Map<String,Integer> linkedHashMap = new LinkedHashMap<String,Integer>();
        //0000000-9999999

        //新增记录
        List<LetterNumber> letterNumberStrs = letterNumberMapper.selectLetterNumberList();
        int i=0;
        for(LetterNumber letterNumber:letterNumberStrs){
            System.out.println("第"+(i++)+"条记录,读取成功"+letterNumber.toString());
            String key = letterNumber.getNumber();
            if(linkedHashMap.containsKey(key)){
                linkedHashMap.put(key,linkedHashMap.get(key)+1);
            }else{
                linkedHashMap.put(key,1);
            }
        }

        for(Entry<String, Integer> map:linkedHashMap.entrySet()){
            System.out.println(map.getKey()+","+map.getValue());
        }

        //结束数据库连接
        MyBatisUtils.closeSession(sqlSession);
    }


}
