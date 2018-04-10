# Content-Provider-test
 利用Content Provider 來取得SD卡內的音樂資訊

#####  檔案名稱: MainActivity.java
```
ipackage com.example.jiancheng.musictest;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    ListView list;
    public static final int RESTORE =1;

    List<String> songname =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView) findViewById(R.id.list);
        int check = ActivityCompat.checkSelfPermission(this,READ_EXTERNAL_STORAGE);
        if (check!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{READ_EXTERNAL_STORAGE},RESTORE);
        }
        else {
            Load();
        }

    }

    private void Load() {

        Cursor c=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,MediaStore.Audio.Media.DEFAULT_SORT_ORDER);

        while (c.moveToNext()){
            String name =c.getString(c.getColumnIndex(MediaStore.Audio.Media.TITLE));
            songname.add(name);
        }

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,songname);
        list.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case RESTORE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Load();
                }
        }
    }
}

```
