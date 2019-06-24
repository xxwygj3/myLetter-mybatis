package com.ixygj.myletter.test;

import com.ixygj.myletter.entity.LetterNumberEndwise;
import com.ixygj.myletter.entity.LetterNumberSum;
import com.ixygj.myletter.mapper.LetterNumberEndwiseMapper;
import com.ixygj.myletter.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LetterNumberEndwiseMapperTest {
    private static SqlSession sqlSession = null;
    private static LetterNumberEndwiseMapper letterNumberEndwiseMapper = null;

    static {
        sqlSession = MyBatisUtils.getSqlSession();
        letterNumberEndwiseMapper = sqlSession.getMapper(LetterNumberEndwiseMapper .class);
    }

    public static void insertLetterNumberEndwiseList(List<LetterNumberEndwise> letterNumberEndwiseList){
        try{
            int i=0;
            for(LetterNumberEndwise letterNumberEndwise:letterNumberEndwiseList){
                //新增记录
                int result = letterNumberEndwiseMapper.insertLetterNumberEndwise(letterNumberEndwise);
                if (result > 0) {
                    sqlSession.commit();
                    System.out.println("第"+(i++)+"条记录,添加成功"+letterNumberEndwise.toString());
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
