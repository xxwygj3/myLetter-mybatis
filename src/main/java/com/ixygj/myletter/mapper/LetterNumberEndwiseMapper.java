package com.ixygj.myletter.mapper;

import com.ixygj.myletter.entity.LetterNumberEndwise;

import java.util.List;

public interface LetterNumberEndwiseMapper {
    List<LetterNumberEndwise> selectLetterNumberEndwiseList();
    int insertLetterNumberEndwise(LetterNumberEndwise letterNumberEndwise);
    int insertForeachLetterNumberEndwise(List<LetterNumberEndwise> letterNumberEndwise);
}
