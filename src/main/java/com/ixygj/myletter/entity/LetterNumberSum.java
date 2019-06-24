package com.ixygj.myletter.entity;

import java.io.Serializable;

public class LetterNumberSum implements Serializable {
    private Integer id;
    private String sumValue;
    private int sumTimes;
    private int totalTimes;
    private int notTimes;
    private String letterNumbersList;
    private String allNumbersList;
    private String notLetterNumbersList;

    public LetterNumberSum() {
    }

    public LetterNumberSum(String sumValue, int sumTimes,int totalTimes,int notTimes, String letterNumbersList,String allNumbersList,String notLetterNumbersList) {
        this.sumValue = sumValue;
        this.sumTimes = sumTimes;
        this.totalTimes = totalTimes;
        this.notTimes = notTimes;
        this.letterNumbersList = letterNumbersList;
        this.allNumbersList = allNumbersList;
        this.notLetterNumbersList = notLetterNumbersList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSumValue() {
        return sumValue;
    }

    public void setSumValue(String sumValue) {
        this.sumValue = sumValue;
    }

    public int getSumTimes() {
        return sumTimes;
    }

    public void setSumTimes(int sumTimes) {
        this.sumTimes = sumTimes;
    }

    public int getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(int totalTimes) {
        this.totalTimes = totalTimes;
    }

    public int getNotTimes() {
        return notTimes;
    }

    public void setNotTimes(int notTimes) {
        this.notTimes = notTimes;
    }

    public String getLetterNumbersList() {
        return letterNumbersList;
    }

    public void setLetterNumbersList(String letterNumbersList) {
        this.letterNumbersList = letterNumbersList;
    }

    public String getAllNumbersList() {
        return allNumbersList;
    }

    public void setAllNumbersList(String allNumbersList) {
        this.allNumbersList = allNumbersList;
    }

    public String getNotLetterNumbersList() {
        return notLetterNumbersList;
    }

    public void setNotLetterNumbersList(String notLetterNumbersList) {
        this.notLetterNumbersList = notLetterNumbersList;
    }

    @Override
    public String toString() {
        return "LetterNumberSum{" +
                "id=" + id +
                ", sumValue='" + sumValue + '\'' +
                ", sumTimes=" + sumTimes +
                ", totalTimes=" + totalTimes +
                ", notTimes=" + notTimes +
                ", letterNumbersList='" + letterNumbersList + '\'' +
                ", allNumbersList='" + allNumbersList + '\'' +
                ", notLetterNumbersList='" + notLetterNumbersList + '\'' +
                '}';
    }
}
