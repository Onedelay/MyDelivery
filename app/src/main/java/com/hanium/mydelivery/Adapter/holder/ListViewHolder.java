package com.hanium.mydelivery.Adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanium.mydelivery.Data.Shop;
import com.hanium.mydelivery.Listener.OnShopClickListener;
import com.hanium.mydelivery.R;

/**
 * Created by su_me on 2017-07-23.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {
    private Shop shop;
    public ViewGroup linear;
    public ImageView restIcon;
    public TextView restName;
    public TextView restAddr;
    public TextView restPhone;
    private OnShopClickListener onShopClickListener;

    public ListViewHolder(View iv, OnShopClickListener onShopClickListener) {
        super(iv);
        this.onShopClickListener = onShopClickListener;
        linear = (ViewGroup) iv.findViewById(R.id.list_item);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListViewHolder.this.onShopClickListener.onShopClick(shop);
            }
        });
        restIcon = (ImageView) iv.findViewById(R.id.mImage);
        restName = (TextView) iv.findViewById(R.id.restau_name);
        restAddr = (TextView) iv.findViewById(R.id.restau_addr);
        restPhone = (TextView) iv.findViewById(R.id.restau_phone);
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
