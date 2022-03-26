package com.example.whatsappclone;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomChatListAdapter extends BaseAdapter {

    private ArrayList<LauncherActivity.ListItem> listData;
    private LayoutInflater layoutInflater;
    public CustomChatListAdapter(Context aContext, ArrayList<LauncherActivity.ListItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View v, ViewGroup vg) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.list_chats, null);
            holder = new ViewHolder();
//            holder.uName = (TextView) v.findViewById(R.id.name);
//            holder.uDesignation = (TextView) v.findViewById(R.id.designation);
//            holder.uLocation = (TextView) v.findViewById(R.id.location);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
//        holder.uName.setText(listData.get(position).getName());
//        holder.uDesignation.setText(listData.get(position).getDesignation());
//        holder.uLocation.setText(listData.get(position).getLocation());
        return v;
    }
    static class ViewHolder {
        TextView uName;
        TextView uDesignation;
        TextView uLocation;
    }
}


//    public View getView(int position, View v, ViewGroup vg) {
//        ViewHolder holder;
//        if (v == null) {
//            v = layoutInflater.inflate(R.layout.list_row, null);
//            holder = new ViewHolder();
//            holder.uName = (TextView) v.findViewById(R.id.name);
//            holder.uDesignation = (TextView) v.findViewById(R.id.designation);
//            holder.uLocation = (TextView) v.findViewById(R.id.location);
//            v.setTag(holder);
//        } else {
//            holder = (ViewHolder) v.getTag();
//        }
//        holder.uName.setText(listData.get(position).getName());
//        holder.uDesignation.setText(listData.get(position).getDesignation());
//        holder.uLocation.setText(listData.get(position).getLocation());
//        return v;
//    }
//static class ViewHolder {
//    TextView uName;
//    TextView uDesignation;
//    TextView uLocation;
//}