package com.ixygj.myletter;

import java.util.List;

public interface LetterNumberMapper {
    List<LetterNumber> selectLetterNumberList();
    String selectMaxIssue();
    int insertLetterNumber(LetterNumber letterNumber);
}
