package com.hanium.mydelivery.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by su_me on 2017-07-23.
 */

public class Shop implements Parcelable {
    public static final int TYPE_KOREA = 0x00;
    public static final int TYPE_CHINA = 0x01;
    public static final int TYPE_JAPEN = 0x02;
    public static final int TYPE_AMERI = 0x03;
    private int iconId;
    private String name;
    private String addr;
    private String phone;
    private int type;

    public Shop() {
    }

    protected Shop(Parcel in) {
        iconId = in.readInt();
        name = in.readString();
        addr = in.readString();
        phone = in.readString();
        type = in.readInt();
    }

    public static final Creator<Shop> CREATOR = new Creator<Shop>() {
        @Override
        public Shop createFromParcel(Parcel in) {
            return new Shop(in);
        }

        @Override
        public Shop[] newArray(int size) {
            return new Shop[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(iconId);
        dest.writeString(name);
        dest.writeString(addr);
        dest.writeString(phone);
        dest.writeInt(type);
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
