package com.ixygj.myletter.test;

import com.ixygj.myletter.entity.LetterNumber;
import com.ixygj.myletter.mapper.LetterNumberMapper;
import com.ixygj.myletter.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LetterNumberMapperTest {
    private static SqlSession sqlSession = null;
    private static LetterNumberMapper letterNumberMapper = null;

    static {
        sqlSession = MyBatisUtils.getSqlSession();
        letterNumberMapper = sqlSession.getMapper(LetterNumberMapper .class);
    }

    public static void insertLetterNumberList(List<LetterNumber> letterNumberList){
        try{
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
        }finally {
            if(null != sqlSession){
                sqlSession.close();
            }
        }
    }

    public static List<LetterNumber>  selectList(){
        List<LetterNumber> letterNumberStrs = letterNumberMapper.selectLetterNumberList();
        return letterNumberStrs;
    }

    public static List<LetterNumber>  selectLastSixIssueList(){
        List<LetterNumber> letterNumberStrs = letterNumberMapper.selectLastSixIssueList();
        return letterNumberStrs;
    }

    public static String selectMaxIssue(){
        String maxIssue = letterNumberMapper.selectMaxIssue();
        //System.out.println(maxIssue);//17154
        return maxIssue;
    }
}
