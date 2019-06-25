package com.ixygj.myletter.mapper;

import com.ixygj.myletter.entity.LetterNumberSum;
import org.apache.ibatis.annotations.Param;

public interface LetterNumberSumMapper {
    int insertLetterNumberSum(LetterNumberSum letterNumberSum);
    LetterNumberSum selectLetterNumberSumBysumValue(@Param("sumValue") String sumValue);
}
