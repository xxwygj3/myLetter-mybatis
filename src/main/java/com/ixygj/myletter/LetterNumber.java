package com.ixygj.myletter;

import java.io.Serializable;

public class LetterNumber implements Serializable {

    private Integer id;
    private String issue;
    private String number;
    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;
    private String sixth;
    private String seventh;

    public LetterNumber() {
    }

    public LetterNumber(String issue, String number) {
        this.issue = issue;
        this.number = number;
    }

    public LetterNumber(String issue, String number, char[] numbers) {
        this.issue = issue;
        this.number = number;
        this.first = String.valueOf(numbers[0]);
        this.second = String.valueOf(numbers[1]);
        this.third = String.valueOf(numbers[2]);
        this.fourth = String.valueOf(numbers[3]);
        this.fifth = String.valueOf(numbers[4]);
        this.sixth = String.valueOf(numbers[5]);
        this.seventh = String.valueOf(numbers[6]);
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFifth() {
        return fifth;
    }

    public void setFifth(String fifth) {
        this.fifth = fifth;
    }

    public String getSixth() {
        return sixth;
    }

    public void setSixth(String sixth) {
        this.sixth = sixth;
    }

    public String getSeventh() {
        return seventh;
    }

    public void setSeventh(String seventh) {
        this.seventh = seventh;
    }

    @Override
    public String toString() {
        return "LetterNumber{" +
                "id='" + id + '\'' +
                ", issue='" + issue + '\'' +
                ", number='" + number + '\'' +
                ", first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", third='" + third + '\'' +
                ", fourth='" + fourth + '\'' +
                ", fifth='" + fifth + '\'' +
                ", sixth='" + sixth + '\'' +
                ", seventh='" + seventh + '\'' +
                '}';
    }
}
