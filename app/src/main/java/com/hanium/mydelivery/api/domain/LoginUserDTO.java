package com.hanium.mydelivery.api.domain;

/**
 * Created by su_me on 2017-09-02.
 */

public class LoginUserDTO {
    private String name;
    private String password;

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
}
