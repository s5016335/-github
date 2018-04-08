package com.example.jiancheng.sql;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fbc;
    public static Database data ;
    RecyclerView recycler;
    Adapter adapter;
    List<User>user=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycler= (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        fbc= (FloatingActionButton) findViewById(R.id.fbc);
        fbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(MainActivity.this,add.class);
                startActivity(it);
            }
        });

        data = new Database(this,"UserDB.db",null,1);
        data.CreatTable("CREATE TABLE IF NOT EXISTS User(name VARCHAR,phone VARCHAR)");


        Load();



    }

    private void Load() {
        user=data.getData();
        adapter=new Adapter(user);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



    @Override
    protected void onResume() {
        super.onResume();

        Load();
    }
}
