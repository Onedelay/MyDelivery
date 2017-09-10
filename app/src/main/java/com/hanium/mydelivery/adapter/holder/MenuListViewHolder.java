package com.hanium.mydelivery.adapter.holder;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hanium.mydelivery.CartEvent;
import com.hanium.mydelivery.data.CartItem;
import com.hanium.mydelivery.data.Menu;
import com.hanium.mydelivery.R;

/**
 * Created by sclab on 2017-08-02.
 */

public class MenuListViewHolder extends RecyclerView.ViewHolder {
    private CartItem cartItem;
    public ConstraintLayout linear;
    public TextView menuName;
    public TextView menuPrice;
    private CartEvent cartEvent;

    Button decre_btn, incre_btn;
    TextView menu_amount;

    public MenuListViewHolder(final View iv, final CartEvent cartEvent){
        super(iv);
        linear = (ConstraintLayout) iv.findViewById(R.id.menu_list_item);
        menuName = (TextView) iv.findViewById(R.id.menu_name);
        menuPrice = (TextView) iv.findViewById(R.id.menu_price);

        menu_amount = (TextView) iv.findViewById(R.id.menu_amount);
        menu_amount.setText(0+"");

        this.cartEvent = cartEvent;
        decre_btn = (Button) iv.findViewById(R.id.decre_btn);
        decre_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(iv.getContext(), "수량 감소 버튼 클릭", Toast.LENGTH_SHORT).show();
                if(cartItem.getItemAmount() > 0) {
                    cartItem.setItemAmount(cartItem.getItemAmount()-1);
                    menu_amount.setText(cartItem.getItemAmount()+ "");
                    cartEvent.removeToCart(getAdapterPosition());
                }
            }
        });
        incre_btn = (Button) iv.findViewById(R.id.incre_btn);
        incre_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(iv.getContext(), "수량 추가 버튼 클릭", Toast.LENGTH_SHORT).show();
                cartItem.setItemAmount(cartItem.getItemAmount()+1);
                menu_amount.setText(cartItem.getItemAmount()+"");
                cartEvent.addToCart(getAdapterPosition());
            }
        });

    }

    public void setMenu(CartItem cartItem){ this.cartItem = cartItem; }
}
