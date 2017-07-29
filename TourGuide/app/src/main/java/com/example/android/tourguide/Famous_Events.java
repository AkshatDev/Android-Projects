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

public class Famous_Events extends Fragment {
    public  Famous_Events(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.events, container, false);

        final ArrayList<Info> lines = new ArrayList();
        lines.add(new Info("The Mandi Shivaratri fair is held as per Hindu calendar every year on the Krishna paksha 13th day/13th night, from 17th to 14th march.", "Shivratri At Mandi ", R.drawable.shivratri));
        lines.add(new Info("Raid De Himalaya is a motorsport started in 1999. It is the world's highest rally raid. The 2009 event ran in six legs from Shimla to Srinagar, between 5 October and 13 October", "Raid ", R.drawable.raid));
        lines.add(new Info("The monastery at Ki is the scene of whirling dances performed by brightly costumed and masked lamas on the last day of this one-week festival", "Ki Chaam ", R.drawable.ki_chaam));
        lines.add(new Info("Kullu Dussehra is the renowned International Mega Dussehra festival observed in the month of October in Himachal Pradesh state in northern India", "Kullu Dussera ", R.drawable.kullu_dussera));
        lines.add(new Info("The holiday is a new year's festival, celebrated on the first day of the lunisolar Tibetan calendar, which corresponds to a date in February or March in the Gregorian calendar", "Losar Festival ", R.drawable.losar_festival));
        lines.add(new Info("The Minjar Fair is held in Himachal Pradesh with great pomp and fanfare. Tourists throng the Chamba region at Himachal Pradesh during the Minjar Fair", "Minjar ", R.drawable.minjar));
        lines.add(new Info("Manimahesh Yatra is pilgrimage to Manimahesh Lake (4115m) situated at the base of Manimahesh Kailash Peak.", "Manimahesh ", R.drawable.manimahesh));
        lines.add(new Info("The IPL is the most-attended cricket league in the world and ranks sixth among all sports leagues.Every year IPL finds it way to dharamshala stadium", "IPL Dharamshala ", R.drawable.ipldharamshala));


        InfoAdapter adapeter = new InfoAdapter(getActivity(), lines, R.color.category_events);

        ListView root = (ListView) rootView.findViewById(R.id.eventlist);
        root.setAdapter(adapeter);

        return rootView;


    }
}
