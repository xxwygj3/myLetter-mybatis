package com.ixygj.myletter;

import java.io.Serializable;
import java.util.List;

public class LetterNumber implements Serializable {

    private Integer id;
    private String issue;
    private String numbers;
    private String number1;
    private String number2;
    private String number3;
    private String number4;
    private String number5;
    private String number6;
    private String number7;
    private int sumValue;
    private String allSubNumbersList;

    public LetterNumber() {
    }

    public LetterNumber(String issue, String numbers,String allSubNumbersList) {
        this.issue = issue;
        this.numbers = numbers;
        initValue(numbers);
        this.allSubNumbersList = allSubNumbersList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public String getNumber4() {
        return number4;
    }

    public void setNumber4(String number4) {
        this.number4 = number4;
    }

    public String getNumber5() {
        return number5;
    }

    public void setNumber5(String number5) {
        this.number5 = number5;
    }

    public String getNumber6() {
        return number6;
    }

    public void setNumber6(String number6) {
        this.number6 = number6;
    }

    public String getNumber7() {
        return number7;
    }

    public void setNumber7(String number7) {
        this.number7 = number7;
    }

    public int getSumValue() {
        return sumValue;
    }

    private void initValue(String numbers) {
        int sumValue = 0;
        String subStr = "";
        for (int i = 0; i < 7; i++) {
            subStr = numbers.substring(i, i + 1);
            sumValue += Integer.valueOf(subStr);
            switch (i) {
                case 0:
                    number1 = subStr;
                    break;
                case 1:
                    number2 = subStr;
                    break;
                case 2:
                    number3 = subStr;
                    break;
                case 3:
                    number4 = subStr;
                    break;
                case 4:
                    number5 = subStr;
                    break;
                case 5:
                    number6 = subStr;
                    break;
                case 6:
                    number7 = subStr;
                    break;
                default:
            }
        }
        this.sumValue = sumValue;
    }

    public String getAllSubNumbersList() {
        return allSubNumbersList;
    }

    public void setAllSubNumbersList(String allSubNumbersList) {
        this.allSubNumbersList = allSubNumbersList;
    }

    @Override
    public String toString() {
        return "LetterNumber{" +
                "id=" + id +
                ", issue='" + issue + '\'' +
                ", numbers='" + numbers + '\'' +
                ", number1='" + number1 + '\'' +
                ", number2='" + number2 + '\'' +
                ", number3='" + number3 + '\'' +
                ", number4='" + number4 + '\'' +
                ", number5='" + number5 + '\'' +
                ", number6='" + number6 + '\'' +
                ", number7='" + number7 + '\'' +
                ", sumValue='" + sumValue + '\'' +
                ", allSubNumbersList=" + allSubNumbersList +
                '}';
    }
}
