package com.hanium.mydelivery.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sclab on 2017-08-02.
 */

public class Menu implements Parcelable {
    private String menu;
    private int price;

    public Menu(){
    }

    protected Menu(Parcel in) {
        menu = in.readString();
        price = in.readInt();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>(){
        @Override
        public Menu createFromParcel(Parcel source) {
            return new Menu(source);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(menu);
        dest.writeInt(price);
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
