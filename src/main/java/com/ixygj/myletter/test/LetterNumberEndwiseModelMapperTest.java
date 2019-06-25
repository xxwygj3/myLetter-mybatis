package com.ixygj.myletter.test;

import com.ixygj.myletter.entity.LetterNumber;
import com.ixygj.myletter.entity.LetterNumberEndwiseModel;
import com.ixygj.myletter.mapper.LetterNumberEndwiseModelMapper;
import com.ixygj.myletter.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LetterNumberEndwiseModelMapperTest {
    private static SqlSession sqlSession = null;
    private static LetterNumberEndwiseModelMapper letterNumberEndwiseModelMapper = null;

    static {
        sqlSession = MyBatisUtils.getSqlSession();
        letterNumberEndwiseModelMapper = sqlSession.getMapper(LetterNumberEndwiseModelMapper .class);
    }

    public static void insertLetterNumberEndwiseModelList(List<LetterNumberEndwiseModel> letterNumberEndwiseModelList){
        try{
            int i=0;
            for(LetterNumberEndwiseModel letterNumberEndwiseModel:letterNumberEndwiseModelList){
                //新增记录
                int result = letterNumberEndwiseModelMapper.insertLetterNumberEndwiseModel(letterNumberEndwiseModel);
                if (result > 0) {
                    sqlSession.commit();
                    System.out.println("第"+(i++)+"条记录,添加成功"+letterNumberEndwiseModel.toString());
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
