package com.example.dllo.micromessage.Main.Bean;

import java.io.Serializable;

/**
 * Created by dllo on 16/11/8.
 */

public class MessageBean implements Serializable{

    private String name;
    private String number;
    private String messageContent;
    private String data;
    private int type;
    private int thread_id;

    public MessageBean(String number, String messageContent, String data, int type, int thread_id) {
        this.number = number;
        this.messageContent = messageContent;
        this.data = data;
        this.type = type;
        this.thread_id = thread_id;
    }

    public MessageBean() {
    }

    public int getThread_id() {
        return thread_id;
    }

    public void setThread_id(int thread_id) {
        this.thread_id = thread_id;
    }

    public MessageBean(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public MessageBean(String number) {
        this.number = number;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
