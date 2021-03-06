package com.ixygj.myletter.mapper;

import com.ixygj.myletter.entity.LetterNumber;

import java.util.List;

public interface LetterNumberMapper {
    List<LetterNumber> selectLetterNumberList();
    List<LetterNumber> selectLastSixIssueList();
    String selectMaxIssue();
    int insertLetterNumber(LetterNumber letterNumber);
}
