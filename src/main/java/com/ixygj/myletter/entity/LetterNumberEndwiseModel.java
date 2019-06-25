package com.ixygj.myletter.entity;

import java.io.Serializable;

public class LetterNumberEndwiseModel implements Serializable {
    private Integer id;
    private String endwiseModel;
    private int modelTimes;

    public LetterNumberEndwiseModel() {
    }

    public LetterNumberEndwiseModel(String endwiseModel, int modelTimes) {
        this.endwiseModel = endwiseModel;
        this.modelTimes = modelTimes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndwiseModel() {
        return endwiseModel;
    }

    public void setEndwiseModel(String endwiseModel) {
        this.endwiseModel = endwiseModel;
    }

    public int getModelTimes() {
        return modelTimes;
    }

    public void setModelTimes(int modelTimes) {
        this.modelTimes = modelTimes;
    }

    @Override
    public String toString() {
        return "LetterNumberEndwiseModel{" +
                "id=" + id +
                ", endwiseModel='" + endwiseModel + '\'' +
                ", modelTimes=" + modelTimes +
                '}';
    }
}
