package com.hanium.mydelivery.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanium.mydelivery.Data.Item;
import com.hanium.mydelivery.Adapter.holder.CartViewHolder;
import com.hanium.mydelivery.Adapter.holder.ItemViewHolder;
import com.hanium.mydelivery.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by su_me on 2017-08-05.
 */

public class CartAdapter extends ExpandableRecyclerViewAdapter<CartViewHolder, ItemViewHolder> {

    public CartAdapter(List<? extends ExpandableGroup> groups){
        super(groups);
    }

    @Override
    public CartViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_parent_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public ItemViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_child_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ItemViewHolder holder, int platPosition, ExpandableGroup group, int childIndex) {
        final Item item = (Item)((group).getItems().get(childIndex));
        holder.onBind(item);
    }

    @Override
    public void onBindGroupViewHolder(CartViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setCartStoreName(group);
    }
}
