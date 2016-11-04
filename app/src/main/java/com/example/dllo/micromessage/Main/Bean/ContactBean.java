package com.example.dllo.micromessage.Main.Bean;

/**
 * Created by dllo on 16/11/1.
 */

public class ContactBean {
    private String  tvName,tvNumber;

    public ContactBean() {
    }

    public ContactBean(String tvName, String tvNumber) {
        this.tvName = tvName;
        this.tvNumber = tvNumber;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvNumber() {
        return tvNumber;
    }

    public void setTvNumber(String tvNumber) {
        this.tvNumber = tvNumber;
    }
}
