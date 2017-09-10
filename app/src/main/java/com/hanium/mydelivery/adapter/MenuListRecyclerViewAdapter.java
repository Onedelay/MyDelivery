package com.hanium.mydelivery.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hanium.mydelivery.CartEvent;
import com.hanium.mydelivery.data.CartItem;
import com.hanium.mydelivery.data.Menu;
import com.hanium.mydelivery.adapter.holder.MenuListViewHolder;
import com.hanium.mydelivery.R;

import java.util.ArrayList;

/**
 * Created by sclab on 2017-08-02.
 */

public class MenuListRecyclerViewAdapter extends RecyclerView.Adapter{

    private ArrayList<CartItem> mListData = new ArrayList<>();
    CartEvent cartEvent;

   // Button decre_btn, incre_btn;

    public MenuListRecyclerViewAdapter(CartEvent cartEvent) {
        this.cartEvent = cartEvent;
    }

    public void setData(ArrayList<CartItem> mListData){
        this.mListData = mListData;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list_item, parent, false), cartEvent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuListViewHolder mvh = (MenuListViewHolder) holder;

        CartItem mData = mListData.get(position);
        mvh.setMenu(mData);
        mvh.menuName.setText(mData.getItemName());
        mvh.menuPrice.setText(mData.getItemPrice()+"원");
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }
}
