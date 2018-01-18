package com.sanke.ilafedoseev.talkchat.Model;

/**
 * Created by ilafedoseev on 17/01/2018.
 */

public class ChatSend {

    private String name;
    private String text;
    private String time;

    public ChatSend(String name, String text, String time) {
        this.name = name;
        this.text = text;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
