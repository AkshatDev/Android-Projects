package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Lucifer on 04-11-2017.
 */

public class Traditional_Food extends Fragment {
    public Traditional_Food(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.events, container, false);


        final ArrayList<Info> lines = new ArrayList();
        lines.add(new Info("No festivities of Himachal are considered complete without Dham.Give it a try!!", "1. Dham ", R.drawable.dham));
        lines.add(new Info("This dessert is prepared with sweetened rice mixed with a generous helping of raisins and other dry fruits.w", "2. Mittha ", R.drawable.mittha));
        lines.add(new Info(" This distinct bread is usually enjoyed with ghee or butter alone or can be savoured with mutton or daal as well.", "3. Sidu ", R.drawable.siddu));
        lines.add(new Info("Babru is like a Himachali variation of the popular kachoris.", "4. Babru ", R.drawable.babru));
        lines.add(new Info("Madra is a form of yoghurt and chickpea flour based gravy popular in pahar cuisine.", "5. Chana Madra ", R.drawable.chana_madra));
        lines.add(new Info("Khatta is indeed a very sumptuous dish made with pumpkin cooked in a spicy and tangy madra gravy and dried raw mango powder or amchoor along with other spices.", "6. Kadoo Ka Khatta", R.drawable.kaddu));
        lines.add(new Info("Another of Himachali delicacy, Chha Gosht is a dish that is made with marinated lamb meat cooked in a gravy of gram flour.", "7. Chha Gosht ", R.drawable.lamb));
        lines.add(new Info("Mash daal or kali daal is made with split black lentils or ma ki daal.", "8. Mash Daal", R.drawable.maah_daal));

        InfoAdapter adapeter = new InfoAdapter(getActivity(), lines, R.color.category_food);
        ListView root = (ListView) rootView.findViewById(R.id.eventlist);
        root.setAdapter(adapeter);

return rootView;
    }
}
