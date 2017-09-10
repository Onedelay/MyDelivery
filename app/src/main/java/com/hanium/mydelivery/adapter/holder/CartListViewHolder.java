package com.hanium.mydelivery.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hanium.mydelivery.data.Cart;

/**
 * Created by su_me on 2017-08-05.
 */

public class CartListViewHolder extends RecyclerView.ViewHolder{
    private Cart cart;
    public LinearLayout linear;

    public CartListViewHolder(final View iv){
        super(iv);
    }
}
