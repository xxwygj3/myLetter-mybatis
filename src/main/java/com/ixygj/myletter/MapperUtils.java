package com.ixygj.myletter;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MapperUtils {
    private static SqlSession sqlSession = null;
    private static LetterNumberMapper letterNumberMapper = null;
    private static LetterNumberSumMapper letterNumberSumMapper = null;
    private static LetterNumberSubMapper letterNumberSubMapper = null;

    static {
        sqlSession = MyBatisUtils.getSqlSession();
        letterNumberMapper = sqlSession.getMapper(LetterNumberMapper.class);
        letterNumberSumMapper = sqlSession.getMapper(LetterNumberSumMapper.class);
        letterNumberSubMapper = sqlSession.getMapper(LetterNumberSubMapper.class);
    }

    public static String selectMaxIssue(){
        String maxIssue = letterNumberMapper.selectMaxIssue();
        //System.out.println(maxIssue);//17154
        return maxIssue;
    }

    public static void insertLetterNumberList(List<LetterNumber> letterNumberList){
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
    }

    public static void insertLetterNumberSumList(List<LetterNumberSum> letterNumberSumList){
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
    }

    public static void insertLetterNumberSubList(List<LetterNumberSub> letterNumberSubList){
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
    }

    public static List<LetterNumber>  selectList(){
        List<LetterNumber> letterNumberStrs = letterNumberMapper.selectLetterNumberList();
        return letterNumberStrs;
    }

    @Override
    protected void finalize() throws Throwable {
        if(null != sqlSession){
            //结束数据库连接
            MyBatisUtils.closeSession(sqlSession);
        }
    }
}
