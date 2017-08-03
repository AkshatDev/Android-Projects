package com.example.android.music_structure;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by Lucifer on 08-11-2017.
 */

public class DataAdapter extends ArrayAdapter<list> {
    public DataAdapter(Activity context, ArrayList<list> lists) {
        super(context, 0,lists);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }


        list currentlist = getItem(position);


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);

        nameTextView.setText(currentlist.getmName());

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.by);
       authorTextView.setText(currentlist.getmAuthor());

        return listItemView;
    }

}
