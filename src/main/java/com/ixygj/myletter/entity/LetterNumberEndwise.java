package com.ixygj.myletter.entity;

import java.io.Serializable;

public class LetterNumberEndwise implements Serializable {
    private Integer id;
    private String endwiseNumbers;
    private int endwiseTimes;

    public LetterNumberEndwise() {
    }

    public LetterNumberEndwise(String endwiseNumbers, int endwiseTimes) {
        this.endwiseNumbers = endwiseNumbers;
        this.endwiseTimes = endwiseTimes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndwiseNumbers() {
        return endwiseNumbers;
    }

    public void setEndwiseNumbers(String endwiseNumbers) {
        this.endwiseNumbers = endwiseNumbers;
    }

    public int getEndwiseTimes() {
        return endwiseTimes;
    }

    public void setEndwiseTimes(int endwiseTimes) {
        this.endwiseTimes = endwiseTimes;
    }

    @Override
    public String toString() {
        return "LetterNumberEndwise{" +
                "id=" + id +
                ", endwiseNumbers='" + endwiseNumbers + '\'' +
                ", endwiseTimes=" + endwiseTimes +
                '}';
    }
}
