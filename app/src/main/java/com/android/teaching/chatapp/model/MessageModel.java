package com.android.teaching.chatapp.model;

public class MessageModel {
    private String username;
    private String text;

    public MessageModel() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
