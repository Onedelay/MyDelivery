//package com.hanium.mydelivery.adapter.holder;
//
//import android.view.View;
//import android.widget.TextView;
//
//import com.hanium.mydelivery.data.CartItem;
//import com.hanium.mydelivery.R;
//import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
//
///**
// * Created by su_me on 2017-08-05.
// */
//
//public class ItemViewHolder extends ChildViewHolder {
//    private TextView itemName;
//    private TextView itemAmount;
//    private TextView itemPrice;
//
//    public ItemViewHolder(View itemView) {
//        super(itemView);
//        itemName = (TextView) itemView.findViewById(R.id.cart_item_name);
//        itemAmount = (TextView) itemView.findViewById(R.id.cart_item_amount);
//        itemPrice = (TextView) itemView.findViewById(R.id.cart_item_price);
//    }
//
//    public void onBind(CartItem cartItem){
//        itemName.setText(cartItem.getItemName());
//        itemAmount.setText(cartItem.getItemAmount());
//        itemPrice.setText(cartItem.getItemPrice());
//    }
//
//    public void setItemName(String name){
//
//    }
//}
