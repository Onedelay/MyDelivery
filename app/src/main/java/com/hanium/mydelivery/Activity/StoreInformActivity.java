package com.hanium.mydelivery.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hanium.mydelivery.Adapter.MenuListRecyclerViewAdapter;
import com.hanium.mydelivery.Handler.BackPressCloseHandler;
import com.hanium.mydelivery.Data.Menu;
import com.hanium.mydelivery.R;
import com.hanium.mydelivery.Data.Shop;
import com.hanium.mydelivery.TestData;

import java.util.ArrayList;

public class StoreInformActivity extends AppCompatActivity {
    private Shop shop;

    private RecyclerView recyclerView;
    private MenuListRecyclerViewAdapter mAdapter;
    private ArrayList<Menu> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_inform);

        // Adding Toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textTitle = (TextView)toolbar.findViewById(R.id.text_title);
        textTitle.setText("My Delivery - 업체정보");

        setSupportActionBar(toolbar);

        shop = (Shop) getIntent().getParcelableExtra(Shop.class.getName());

        String restInfo = shop.getName()+"\n"+shop.getAddr()+"\n"+shop.getPhone();

        TextView restInfoV = (TextView) findViewById(R.id.info);
        restInfoV.setText(restInfo);

        data = new ArrayList<>();
        TestData testData = new TestData();

        for(int i=0; i<testData.menuCnt; i++){
            Menu menu = new Menu();
            menu.setMenu(testData.T_Menus[i]);
            menu.setPrice(testData.T_Prices[i]);
            data.add(menu);
        }

        recyclerView = (RecyclerView) findViewById(R.id.menu_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(StoreInformActivity.this, DividerItemDecoration.VERTICAL)); // division line

        mAdapter = new MenuListRecyclerViewAdapter();
        mAdapter.setData(data);
        recyclerView.setAdapter(mAdapter);

        Button direct_order_btn = (Button) findViewById(R.id.direct_order);
        direct_order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StoreInformActivity.this, "주문페이지로 이동", Toast.LENGTH_SHORT).show();
            }
        });

        Button add2cart = (Button) findViewById(R.id.add2cart);
        add2cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertShow();
            }
        });

        }

        void alertShow(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("알림 메시지");
            builder.setMessage("장바구니에 성공적으로 담겼습니다.");
            builder.setPositiveButton("장바구니 보러가기",
                    new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            Toast.makeText(StoreInformActivity.this, "장바구니 리스트로 이동", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(StoreInformActivity.this, CartActivity.class);
                            startActivity(intent);
                        }
                    });
            builder.setNegativeButton("계속 쇼핑하기",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"가게(?) 리스트로 이동",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
            builder.show();
        }

}
