# Content-Provider-test
練習 Content Provider 聯絡人

#####  檔案名稱: MainActivity.java
```
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.WRITE_CONTACTS;

public class MainActivity extends AppCompatActivity {

    public static final int RESTORE =1;  //設定回傳值

    SimpleCursorAdapter adapter;

    ListView list;

    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=  (ListView) findViewById(R.id.list);
        
//確認是否有取得聯絡人權限
        int permission = ActivityCompat.checkSelfPermission(this, READ_CONTACTS);
        
        if (permission!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{READ_CONTACTS,WRITE_CONTACTS},RESTORE);

        }
        else{

            readContacts();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case RESTORE :
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    readContacts();

                }
        }
    }



    private void readContacts() {
      
        ContentResolver resolver = getContentResolver();
         c = resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

第一種       
//直接使用 SimpleCursorAdapter  取得聯絡人資訊
        
        adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                c,
                new String[]{ContactsContract.Contacts.DISPLAY_NAME},
                new int[]{android.R.id.text1},
                0);

        list.setAdapter(adapter);
  
 第二種  可創造 Array<User> user 再用 Recyclerview  顯示
        /＊
         while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex(ContactsContract.Contacts._ID)); //取得ID
            String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)); //取得聯絡人姓名
  
            user.add(new User(name));     
        }
        ＊/ 
    }

}
```
