package com.example.dllo.micromessage.Main.Bean;

/**
 * Created by dllo on 16/10/26.
 */

public class TalkRecordBean {

    private String tvName,tvNum,tvYear;


    public TalkRecordBean(String tvName, String tvNum, String tvYear) {
        this.tvName = tvName;
        this.tvNum = tvNum;
        this.tvYear = tvYear;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvNum() {
        return tvNum;
    }

    public void setTvNum(String tvNum) {
        this.tvNum = tvNum;
    }

    public String getTvYear() {
        return tvYear;
    }

    public void setTvYear(String tvYear) {
        this.tvYear = tvYear;
    }
}
