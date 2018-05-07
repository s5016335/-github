package com.example.jiancheng.listtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jiancheng.listtest.model.User;

import java.util.List;

/**
 * Created by jiancheng on 2018/4/4.
 */

public class ListAdapter extends BaseAdapter {

    private List<User> users;
    private Context mContext;

    public ListAdapter(List<User> users, Context mContext) {
        this.users = users;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static  class ViewHoler{
        TextView name,age;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        ViewHoler holer=null;

        if (convertView==null){
            holer = new ViewHoler();
            convertView= layoutInflater.inflate(R.layout.item,null);
            holer.name= (TextView)convertView. findViewById(R.id.name);
            holer.age= (TextView)convertView. findViewById(R.id.age);
            convertView.setTag(holer);

        }
        else {
            holer=(ViewHoler)convertView.getTag();
        }

        holer.name.setText(users.get(position).getName());
        holer.age.setText(users.get(position).getAge());

        return convertView;
    }



}
