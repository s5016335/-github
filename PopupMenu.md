# PopupMenu

# PopupMenu基本介紹

PopupMenu的選單資源(menu\ ****.xml)
```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/save"
        android:title="儲存"/>

    <item
        android:id="@+id/delet"
        android:title="刪除"/>
</menu>

```

PopupMenu的基本設定
```
	// View 為你自定義的物件 ex: TextView name= (Text) findViewById(R.id.name); name 就為View
 	PopupMenu pop = new PopupMenu(Context context, View anchor)
 	// **** 為自定義item .xml
 	pop.getMenuInflater.inflate(R.menu.****);

 	// PopupMenu 點擊動作
 	pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                    	//你所輸入的程式
                      
                        return false;
                    }
                });

    // PopupMenu 要有.show()才會執行
    pop.show();


```

# PopupMenu 範例程式碼 
這是一個結合 RecyclerView 和 PopupMenu 的範例

MainActivity 使用的佈局資源檔(activity_main.xml)：
```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/cardview_dark_background"
    android:orientation="vertical"
    tools:context="com.example.jiancheng.dialog.MainActivity">



    <android.support.v7.widget.Toolbar
        android:id="@+id/toot"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:popupTheme="@style/AppTheme.PopupOverlay"
        android:theme="@style/AppTheme.AppBarOverlay"/>


    <android.support.v7.widget.RecyclerView
        android:id="@+id/recycler"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    </android.support.v7.widget.RecyclerView>

</LinearLayout>

```

PopupMenu 使用的佈局資源檔(op.xml)：
```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/save"
        android:title="儲存"/>

    <item
        android:id="@+id/delet"
        android:title="刪除"/>
</menu>
```

recycleview_item使用的佈局資源檔(recycle_item.xml)：
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/cardview_dark_background"
    android:layout_marginTop="5dp"
    >

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

       <LinearLayout
           android:layout_width="340dp"
           android:layout_height="wrap_content"
           android:id="@+id/liname"
           >
           <TextView
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:text="name"
               android:textSize="20dp"
               android:id="@+id/name"
               android:textColor="#FFFFFF"
               />

       </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_below="@+id/liname"

            >

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@+id/name"
                android:text="age"
                android:textSize="12dp"
                android:id="@+id/age"
                android:textColor="#FFFFFF"/>
        </LinearLayout>

        <LinearLayout
            android:layout_width="10dp"
            android:layout_height="wrap_content"
            android:layout_toRightOf="@+id/liname"
            android:layout_centerVertical="true"

            >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="&#8942;"
            android:textSize="18dp"
            android:layout_below="@+id/age"
            android:id="@+id/op"
            android:textColor="#FFFFFF" />
        </LinearLayout>

     <!--   <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_below="@+id/op">
            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textSize="1dp"
                android:background="#000000"
                android:layout_above="@+id/op"
                />

        </LinearLayout>
-->
    </RelativeLayout>

</RelativeLayout>

```

MainActivity.java 檔：
```


package com.example.jiancheng.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<User> user = new ArrayList<>();
    myapater apater;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toot= (Toolbar) findViewById(R.id.toot);
        setSupportActionBar(toot);

        recyclerView =(RecyclerView) findViewById(R.id.recycler);
        user.add(new User("PC_Shopping","[電蝦]天佑花蓮"));
        user.add(new User("PlayStation","[PS4]陪山田前輩狩獵一整天"));
        user.add(new User("MobileComm","[通訊]MWC2018暖身中"));
        user.add(new User("AndroidDev","[AndroidDev]開發者們，歡迎光臨"));
        user.add(new User("Soft_Job","能不能給我一行的code時間"));

        apater = new myapater(this,user);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(apater);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.title,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.tr:

                st=!st;
                if (st){
                    recyclerView.setLayoutManager(new GridLayoutManager(this,2));
                    recyclerView.setAdapter(apater);

                }
                else{
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    recyclerView.setAdapter(apater);
                }
            break;

            case R.id.delet_all:

                user.clear();
                apater.notifyDataSetChanged();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle().equals("刪除"))
        {
            user.remove(item.getOrder());
            apater.notifyDataSetChanged();
        }

        return super.onContextItemSelected(item);
    }


}

```

myapater.java 檔：
```
package com.example.jiancheng.dialog;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class myapater extends RecyclerView.Adapter<myapater.View> {

    List<User> muser;
    Context c;

    public myapater(Context conent,List<User> user) {
        this.muser=user;
        this.c=conent;
    }

    @Override
    public myapater.View onCreateViewHolder(ViewGroup parent, int viewType) {

        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycer_item,parent,false);

        View view1 = new View(view);

        return view1;

    }

    @Override
    public void onBindViewHolder(final myapater.View holder, final int position) {

        holder.name.setText(muser.get(position).getName());
        holder.age.setText(muser.get(position).getAge());

        //當 textview被點擊啟動 PopupMenu
        holder.op.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(final android.view.View v) {
                PopupMenu pop = new PopupMenu(c,holder.op);
                pop.inflate(R.menu.op);
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                       switch (item.getItemId()){

                           case R.id.save:
                               Toast.makeText(c, "保存", Toast.LENGTH_SHORT).show();
                                break;
                           case R.id.delet:
                               muser.remove(position);
                               notifyDataSetChanged();
                               break;
                       }
                        return false;
                    }
                });
                pop.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return muser.size();
    }

    public class View  extends RecyclerView.ViewHolder {

       TextView name,age,op;

        public View(android.view.View itemView) {
            super(itemView);

            name= itemView. findViewById(R.id.name);
            age= itemView. findViewById(R.id.age);
            op= itemView. findViewById(R.id.op);

       //     itemView.setOnCreateContextMenuListener(new android.view.View.OnCreateContextMenuListener() {
       //         @Override
       //         public void onCreateContextMenu(ContextMenu menu, android.view.View v, ContextMenu.ContextMenuInfo menuInfo) {
        //            menu.add(0,0,getAdapterPosition(),"刪除");
        //        }
        //    });

        }
    }
}

```

User.java檔：
```
package com.example.jiancheng.dialog;

public class User {

    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

```
