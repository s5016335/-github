package com.example.jiancheng.sql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add extends AppCompatActivity {

    EditText name,phone;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name=(EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.phone);
        btn=(Button) findViewById(R.id.yes);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    MainActivity.data.add(name.getText().toString(),phone.getText().toString());
                    Toast.makeText(add.this, "資料新增成功", Toast.LENGTH_SHORT).show();
                    finish();

                }catch (Exception e){

                    Toast.makeText(add.this, "資料新增失敗", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
