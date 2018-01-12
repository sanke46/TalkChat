package com.sanke.ilafedoseev.talkchat.Model;

import java.util.Date;

/**
 * Created by ilafedoseev on 08/11/2017.
 */

public class Message {

    private String name;
    private Date time;
    private String text;

    public Message(String name, Date time, String text) {
        this.name = name;
        this.time = time;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
