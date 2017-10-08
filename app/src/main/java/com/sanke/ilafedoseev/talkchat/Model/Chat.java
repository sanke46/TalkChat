package com.sanke.ilafedoseev.talkchat.Model;

/**
 * Created by ilafedoseev on 07/10/2017.
 */

public class Chat {

    private String name;
    private String text;
    private String time;

    public Chat(String name, String text, String time) {
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

    public String getAvatarName(String name) {
        String resultName = "";
        String[] letters = name.split(" ");
        resultName = letters[0].substring(0,1) + letters[1].substring(0,1);
        return resultName;
    }
}
