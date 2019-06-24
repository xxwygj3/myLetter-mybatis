package com.ixygj.myletter.entity;

import java.io.Serializable;

public class LetterNumberSub implements Serializable {
    private Integer id;
    private String subNumbers;
    private int subTimes;

    public LetterNumberSub() {
    }

    public LetterNumberSub(String subNumbers, int subTimes) {
        this.subNumbers = subNumbers;
        this.subTimes = subTimes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubNumbers() {
        return subNumbers;
    }

    public void setSubNumbers(String subNumbers) {
        this.subNumbers = subNumbers;
    }

    public int getSubTimes() {
        return subTimes;
    }

    public void setSubTimes(int subTimes) {
        this.subTimes = subTimes;
    }

    @Override
    public String toString() {
        return "LetterNumberSub{" +
                "id=" + id +
                ", subNumbers='" + subNumbers + '\'' +
                ", subTimes=" + subTimes +
                '}';
    }
}
