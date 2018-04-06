package com.example.jiancheng.listtest;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jiancheng.listtest.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    SwipeRefreshLayout swi;
    List<User>user = new ArrayList<>();
    ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       list= (ListView) findViewById(R.id.list);
       swi= (SwipeRefreshLayout) findViewById(R.id.swi);

        user.add(new User("<<鬥陣特工>>遊戲總監Jeff公開捍衛密令最新任務宣傳影片","GNN 新聞 多平台"));
        user.add(new User("試玩 跑酷遊戲 跟著庫達們一起接力衝鋒打倒頭目","GNN 新聞 手機"));

        adapter = new ListAdapter(user,getApplicationContext());

        swi.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                load();
            }
        });

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

    }

    private void load() {
        user.add(new User("<<鬥陣特工>>遊戲總監Jeff公開捍衛密令最新任務宣傳影片","GNN 新聞 多平台"));
        user.add(new User("試玩 跑酷遊戲 跟著庫達們一起接力衝鋒打倒頭目","GNN 新聞 手機"));
        adapter.notifyDataSetChanged();
        swi.setRefreshing(false);

    }


}
