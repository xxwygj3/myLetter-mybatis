package com.ixygj.myletter.test;

import com.ixygj.myletter.entity.LetterNumberSum;
import com.ixygj.myletter.mapper.LetterNumberSumMapper;
import com.ixygj.myletter.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LetterNumberSumMapperTest {
    private static SqlSession sqlSession = null;
    private static LetterNumberSumMapper letterNumberSumMapper = null;

    static {
        sqlSession = MyBatisUtils.getSqlSession();
        letterNumberSumMapper = sqlSession.getMapper(LetterNumberSumMapper .class);
    }

    public static void insertLetterNumberSumList(List<LetterNumberSum> letterNumberSumList){
        try{
            int i=0;
            for(LetterNumberSum letterNumberSum:letterNumberSumList){
                //新增记录
                int result = letterNumberSumMapper.insertLetterNumberSum(letterNumberSum);
                if (result > 0) {
                    sqlSession.commit();
                    System.out.println("第"+(i++)+"条记录,添加成功"+letterNumberSum.toString());
                } else {
                    sqlSession.rollback();
                }
            }
        }finally {
            if(null != sqlSession){
                sqlSession.close();
            }
        }
    }
}
