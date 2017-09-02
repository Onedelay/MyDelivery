package com.hanium.mydelivery.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by su_me on 2017-08-05.
 */

public class Cart extends ExpandableGroup<Item> implements Parcelable {
    private String storeName;
    private int totalPrice;

    public Cart(String storeName, List<Item> items){
        super(storeName, items);
    }




    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
