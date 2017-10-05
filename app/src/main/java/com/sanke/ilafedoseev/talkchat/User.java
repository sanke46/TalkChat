package com.sanke.ilafedoseev.talkchat;

/**
 * Created by ilafedoseev on 08/08/2017.
 */

public class User {
    private String name;
    private String password;
    private String email;
    private boolean status;

    public User (String name, String password, String email, boolean status) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAvatarName(String name) {
        String resultName = "";
        String[] letters = name.split(" ");
        resultName = letters[0].substring(0,1) + letters[1].substring(0,1);
        return resultName;
    }
}
