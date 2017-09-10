package com.hanium.mydelivery.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by su_me on 2017-08-05.
 */

public class CartItem implements Parcelable {
    String itemName;
    int itemAmount;
    int itemPrice;

    public CartItem(){

    }

    protected CartItem(Parcel in){
        itemName = in.readString();
        itemAmount = in.readInt();
        itemPrice = in.readInt();
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel source) {
            return new CartItem(source);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
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
