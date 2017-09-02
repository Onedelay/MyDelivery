package com.hanium.mydelivery.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hanium.mydelivery.Data.Menu;
import com.hanium.mydelivery.Adapter.holder.MenuListViewHolder;
import com.hanium.mydelivery.R;

import java.util.ArrayList;

/**
 * Created by sclab on 2017-08-02.
 */

public class MenuListRecyclerViewAdapter extends RecyclerView.Adapter{

    private ArrayList<Menu> mListData = new ArrayList<>();

   // Button decre_btn, incre_btn;

    public void setData(ArrayList<Menu> mListData){
        this.mListData = mListData;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuListViewHolder mvh = (MenuListViewHolder) holder;

        Menu mData = mListData.get(position);
        mvh.setMenu(mData);
        mvh.menuName.setText(mData.getMenu());
        mvh.menuPrice.setText(mData.getPrice()+"원");
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }
}
