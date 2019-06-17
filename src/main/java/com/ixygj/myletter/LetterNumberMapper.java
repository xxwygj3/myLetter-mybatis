package com.ixygj.myletter;

import java.util.List;

public interface LetterNumberMapper {
    List<LetterNumber> selectLetterNumberList();
    int insertLetterNumber(LetterNumber letterNumber);
}
