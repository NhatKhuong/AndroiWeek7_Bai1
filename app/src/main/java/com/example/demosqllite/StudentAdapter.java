package com.example.demosqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context ctx;
    private int layoutItem;
    private List<Contact> contacttList;

    public StudentAdapter(Context ctx, int layoutItem, List<Contact> contacttList) {
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.contacttList = contacttList;
    }

    @Override
    public int getCount() {
        if(contacttList.size() != 0){
            return  contacttList.size();
        }
        return  0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(ctx).inflate(layoutItem,viewGroup,false);
        TextView name = view.findViewById(R.id.name);

        name.setText(contacttList.get(i).getName());
        return view;
    }


}
