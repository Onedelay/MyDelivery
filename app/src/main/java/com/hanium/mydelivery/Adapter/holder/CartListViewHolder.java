package com.hanium.mydelivery.Adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanium.mydelivery.Data.Cart;

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
