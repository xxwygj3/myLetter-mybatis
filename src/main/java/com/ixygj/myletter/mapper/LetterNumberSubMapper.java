package com.ixygj.myletter.mapper;

import com.ixygj.myletter.entity.LetterNumberSub;

import java.util.List;

public interface LetterNumberSubMapper {
    int insertLetterNumberSub(LetterNumberSub letterNumberSub);
    int insertForeachLetterNumberSub(List<LetterNumberSub> letterNumberSubList);
}
