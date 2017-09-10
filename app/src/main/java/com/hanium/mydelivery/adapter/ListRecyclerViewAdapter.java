package com.hanium.mydelivery.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hanium.mydelivery.adapter.holder.ListViewHolder;
import com.hanium.mydelivery.listener.OnShopClickListener;
import com.hanium.mydelivery.R;
import com.hanium.mydelivery.data.Shop;

import java.util.ArrayList;

/**
 * Created by su_me on 2017-07-23.
 */

public class ListRecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<Shop> mListData = new ArrayList<>();
    private OnShopClickListener onShopClickListener;

    public ListRecyclerViewAdapter(OnShopClickListener onShopClickListener) {
        this.onShopClickListener = onShopClickListener;
    }

    public void setData(ArrayList<Shop> mListData) {
        this.mListData = mListData;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, parent, false), onShopClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListViewHolder vh = (ListViewHolder)holder;

        Shop mData = mListData.get(position);
        vh.setShop(mData);
        vh.restIcon.setImageResource(mData.getIconId());
        vh.restName.setText(mData.getName());
        vh.restAddr.setText(mData.getAddr());
        vh.restPhone.setText(mData.getPhone());
    }

    @Override
    public int getItemCount() {
        return mListData == null
                ? 0
                : mListData.size();
    }
}
