package com.sanke.ilafedoseev.talkchat.Model;

/**
 * Created by ilafedoseev on 06/11/2017.
 */

public class Friend {

    private String name;
    private String email;
//    private boolean online;

    public Friend(String name, String email) {
        this.name = name;
        this.email = email;
//        this.online = b;
    }

    public Friend() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarName(String name) {
        String resultName = "";
        String[] letters = name.split(" ");
        resultName = letters[0].substring(0,1) + letters[1].substring(0,1);
        return resultName;
    }
}
