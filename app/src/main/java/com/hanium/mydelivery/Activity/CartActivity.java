package com.hanium.mydelivery.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hanium.mydelivery.Data.Cart;
import com.hanium.mydelivery.Handler.BackPressCloseHandler;
import com.hanium.mydelivery.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Adding Toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textTitle = (TextView)toolbar.findViewById(R.id.text_title);
        textTitle.setText("My Delivery - 장바구니");

        setSupportActionBar(toolbar);

        //List<Cart> carts =

    }
}
