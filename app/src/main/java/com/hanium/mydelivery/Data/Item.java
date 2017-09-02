package com.hanium.mydelivery.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by su_me on 2017-08-05.
 */

public class Item implements Parcelable {
    String itemName;
    int itemAmount;
    int itemPrice;

    public Item(){

    }

    protected Item(Parcel in){
        itemName = in.readString();
        itemAmount = in.readInt();
        itemPrice = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeInt(itemAmount);
        dest.writeInt(itemPrice);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
