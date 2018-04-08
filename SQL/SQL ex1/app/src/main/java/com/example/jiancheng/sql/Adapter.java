package com.example.jiancheng.sql;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jiancheng on 2018/4/6.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<User>users;

    public Adapter(List<User> users) {
        this.users = users;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.name.setText(users.get(position).getName());
        holder.phone.setText(users.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone;
        public ViewHolder(View itemView) {
            super(itemView);
           name= (TextView)itemView. findViewById(R.id.nameshow);
           phone= (TextView)itemView. findViewById(R.id.phoneshow);

        }
    }
}
