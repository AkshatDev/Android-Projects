package com.example.android.newsapp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.name;
import static android.R.attr.type;

/**
 * Created by Lucifer on 07-11-2017.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, List<News> earthquakes)
    {
        super(context,0,earthquakes);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }


        News currentnews = getItem(position);

         TextView name=(TextView) listItemView.findViewById(R.id.name);
        name.setText(currentnews.getmname());
        TextView type = (TextView) listItemView.findViewById(R.id.type);

        type.setText(currentnews.getwriter());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView author = (TextView) listItemView.findViewById(R.id.title);

        author.setText(currentnews.gettitle());

        TextView date = (TextView) listItemView.findViewById(R.id.date);

        date.setText(currentnews.getpublishdate());

        return listItemView;
    }

}
