package com.hanium.mydelivery.api.domain;

/**
 * Created by su_me on 2017-11-11.
 */

public class ImageLoginUserDTO {
    private String name;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return photo;
    }

    public void setImageName(String imageName) {
        this.photo = imageName;
    }
}
