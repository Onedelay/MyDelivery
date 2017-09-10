package com.hanium.mydelivery.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hanium.mydelivery.activity.StoreInformActivity;
import com.hanium.mydelivery.adapter.ListRecyclerViewAdapter;
import com.hanium.mydelivery.listener.OnShopClickListener;
import com.hanium.mydelivery.R;
import com.hanium.mydelivery.data.Shop;
import com.hanium.mydelivery.TestData;
import com.hanium.mydelivery.util.RetrofitHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by su_me on 2017-07-23.
 */

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListRecyclerViewAdapter mAdapter;

    public static ListFragment newInstace(int type) {
        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mAdapter = new ListRecyclerViewAdapter(onShopClickListener);

        // 서버에서 데이터 받기
        int type = getArguments().getInt("type", 0);
        RetrofitHelper.getInstance().getRstrList(new Callback<ArrayList<Shop>>() {
            @Override
            public void onResponse(Call<ArrayList<Shop>> call, Response<ArrayList<Shop>> response) {
                if(response.code() == 200) {
                    Toast.makeText(getContext(), "onResponse", Toast.LENGTH_SHORT).show();
                    ArrayList<Shop> list = response.body();
                    mAdapter.setData(list);
                } else {
                    Log.i("WJY", "code:" + response.code());
                    onFailure(call, new Exception("Not found"));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Shop>> call, Throwable t) {
                t.printStackTrace();
                TestData list = new TestData();
                ArrayList<Shop> shops = new ArrayList<Shop>();
                for(int i=0; i<5; i++){
                    Shop shop = new Shop();
                    shop.setIconId(R.drawable.yeopgi);
                    shop.setName(list.T_Name[i]);
                    shop.setAddr(list.T_Addr[i]);
                    shop.setPhone(list.T_Phone[i]);
                    shops.add(shop);
                }

                mAdapter.setData(shops);
            }
        }, type);

        recyclerView.setAdapter(mAdapter);

        return v;
    }


    private OnShopClickListener onShopClickListener = new OnShopClickListener() {
        @Override
        public void onShopClick(Shop shop) {
            Intent intent = new Intent(getContext(), StoreInformActivity.class);
            intent.putExtra(Shop.class.getName(), shop);
            startActivity(intent);
        }
    };
}
