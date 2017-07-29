package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Lucifer on 04-11-2017.
 */

public class Hotels extends Fragment {

    public Hotels(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.events, container, false);

        final ArrayList<Info> lines = new ArrayList();
        lines.add(new Info("The Mall, Train Station Area, Shimla, Indian, Multicuisine", "Cecil Hotel,Shimla ", R.drawable.cecil));
        lines.add(new Info("Mediterranean, Tapas, Vegetarian, Pizza & Pasta", "Casa Bella Vista, Manali ", R.drawable.casa_bella_vista));
        lines.add(new Info("Jogibara Road , McLeod Ganj , Upper Dharamsala, Dharamsala, India", "Lung Ta, McLeod Ganj", R.drawable.lung_ta_restaurant_mcleod));
        lines.add(new Info("House #1 Jogiwara Road, Dharamshala, India Chinese, Italian, Israeli, Cafu00e9", "Tibet Kitchen, Dharamshala ", R.drawable.tibet_itchen_dharamshala));
        lines.add(new Info("TA perennial favourite for pizza, lasagne, homemade tofu, Turkish kebabs, lamb and chicken dishes and good Israeli specials.", "Evergreen, Solan ", R.drawable.evergreen_kasol));
        lines.add(new Info("Rasta is the top traveller hang-out for its well-prepared breakfasts, soups, salads, momos.", "Rasta Cafe, Vashisht ", R.drawable.rasta_cafe_vashist));
        lines.add(new Info("Has good coffee, good wi-fi, views across the lake and excellent all-day breakfasts, cakes, juices, teas and other snacks and light dishes.", "Emaho Bistro, Rewalshar Lake ", R.drawable.emaho_bistro));
        lines.add(new Info("Shangrila is run by monks of the Gyudmed monastery, some of whom wait on tables and help to engender a notably friendly atmosphere. ", "Shangri La, Mcleod Ganj ", R.drawable.shangri_la));


        InfoAdapter adapeter = new InfoAdapter(getActivity(), lines, R.color.category_hotels);

        ListView root = (ListView) rootView.findViewById(R.id.eventlist);
        root.setAdapter(adapeter);

        return rootView;


    }
}
