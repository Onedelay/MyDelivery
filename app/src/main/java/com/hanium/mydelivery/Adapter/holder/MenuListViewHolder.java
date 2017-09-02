package com.hanium.mydelivery.Adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hanium.mydelivery.Data.Menu;
import com.hanium.mydelivery.R;

/**
 * Created by sclab on 2017-08-02.
 */

public class MenuListViewHolder extends RecyclerView.ViewHolder {
    private Menu menu;
    public LinearLayout linear;
    public TextView menuName;
    public TextView menuPrice;

    Button decre_btn, incre_btn;
    TextView menu_amount;

    int amount;

    public MenuListViewHolder(final View iv){
        super(iv);
        linear = (LinearLayout) iv.findViewById(R.id.menu_list_item);
        menuName = (TextView) iv.findViewById(R.id.menu_name);
        menuPrice = (TextView) iv.findViewById(R.id.menu_price);

        menu_amount = (TextView) iv.findViewById(R.id.menu_amount);
        menu_amount.setText(0+"");

        decre_btn = (Button) iv.findViewById(R.id.decre_btn);
        decre_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(iv.getContext(), "수량 감소 버튼 클릭", Toast.LENGTH_SHORT).show();
                if(amount > 0) {
                    amount = Integer.parseInt(menu_amount.getText().toString());
                    menu_amount.setText((--amount) + "");
                }
            }
        });

        incre_btn = (Button) iv.findViewById(R.id.incre_btn);
        incre_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(iv.getContext(), "수량 추가 버튼 클릭", Toast.LENGTH_SHORT).show();
                amount = Integer.parseInt(menu_amount.getText().toString());
                menu_amount.setText((++amount) +"");
            }
        });

    }

    public void setMenu(Menu menu){ this.menu = menu; }
}
