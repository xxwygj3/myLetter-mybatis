package com.ixygj.myletter.test;

import com.ixygj.myletter.entity.LetterNumberSub;
import com.ixygj.myletter.mapper.LetterNumberSubMapper;
import com.ixygj.myletter.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LetterNumberSubMapperTest {
    private static SqlSession sqlSession = null;
    private static LetterNumberSubMapper letterNumberSubMapper = null;

    static {
        sqlSession = MyBatisUtils.getSqlSession();
        letterNumberSubMapper = sqlSession.getMapper(LetterNumberSubMapper .class);
    }

    public static void insertLetterNumberSubList(List<LetterNumberSub> letterNumberSubList){
        try{
            int i=0;
            for(LetterNumberSub letterNumberSub:letterNumberSubList){
                //新增记录
                int result = letterNumberSubMapper.insertLetterNumberSub(letterNumberSub);
                if (result > 0) {
                    sqlSession.commit();
                    System.out.println("第"+(i++)+"条记录,添加成功"+letterNumberSub.toString());
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
