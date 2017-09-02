package com.hanium.mydelivery.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanium.mydelivery.Adapter.MenuListRecyclerViewAdapter;
import com.hanium.mydelivery.Data.Menu;
import com.hanium.mydelivery.R;
import com.hanium.mydelivery.TestData;

import java.util.ArrayList;

/**
 * Created by sclab on 2017-08-02.
 */

public class MenuListFragment extends Fragment{
    private RecyclerView recyclerView;
    private MenuListRecyclerViewAdapter mAdapter;
    private ArrayList<Menu> data;

    public static MenuListFragment newInstance() {
        MenuListFragment fragment = new MenuListFragment();
        return fragment;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        data = new ArrayList<>();
//        TestData testData = new TestData();
//
//        for(int i=0; i<testData.menuCnt; i++){
//            Menu menu = new Menu();
//            menu.setMenu(testData.T_Menus[i]);
//            menu.setPrice(testData.T_Prices[i]);
//            data.add(menu);
//        }
//    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        data = new ArrayList<>();
        TestData testData = new TestData();

        for(int i=0; i<testData.menuCnt; i++){
            Menu menu = new Menu();
            menu.setMenu(testData.T_Menus[i]);
            menu.setPrice(testData.T_Prices[i]);
            data.add(menu);
        }

        View v = inflater.inflate(R.layout.activity_store_inform, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.menu_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        mAdapter = new MenuListRecyclerViewAdapter();
        mAdapter.setData(data);
        recyclerView.setAdapter(mAdapter);
        return v;
    }
}
