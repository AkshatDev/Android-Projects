package com.example.android.tourguide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lucifer on 04-11-2017.
 */

public class InfoAdapter extends ArrayAdapter<Info> {


    private  int colora;

    public InfoAdapter(Context context, ArrayList<Info> words, int colorjj) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        colora=colorjj;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Info currentlist = getItem(position);


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.info);

        defaultTextView.setText(currentlist.getdDescription());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.subject);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentlist.getHeading());

        ImageView zz= (ImageView) listItemView.findViewById(R.id.ima);

        zz.setImageResource(currentlist.getimagerosuorceid());



        View textcontainer= listItemView.findViewById(R.id.aaaa);
        int color= ContextCompat.getColor(getContext(),colora);
        textcontainer.setBackgroundColor(color);
        return listItemView;
    }

}


