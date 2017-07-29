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

public class Places extends Fragment {
    public  Places(){};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.events, container, false);
        final ArrayList<Info> lines = new ArrayList<Info>();
        lines.add(new Info("Attractions:- Naina Devi Temple, Gobind Sagar, Bhakar Dam, Hadimba Devi Temple, Gugga Gehrwin Temple. ","Bilsapur", R.drawable.bilaspur));
        lines.add(new Info("Attracions:- Rastriya Military School,Chail Sanctuary,Sadhupul,Chail Military School,Chail Gurudwara", "Chail ", R.drawable.chail));
        lines.add(new Info("Attracions:- Champavati Temple,Lakshmi Narayan temples,Akhand Chandi Palace,Church of Scotland", "Chamba ", R.drawable.chamba));
        lines.add(new Info("Attractios:-Khajjiar Lake,Panchpula,Chamera Dam,Dainkund Peak,Gandhi Chowk Shopping Plaza,Sach Pass", "Dalhousie ", R.drawable.dalhousie));
        lines.add(new Info("Attractions:-Chintpurni,St. John in the Wilderness Church,Kareri Lake,Tibet Museum", "Dharamshala ", R.drawable.dharamshala));
        lines.add(new Info("Attractions:-Central Research Institute,Baptist Church,Christ Church,Gurudwara Shri Guru Nanak Ji,Nahri Temple", "Kasauli", R.drawable.kasauli));
        lines.add(new Info("Attractions:-Mall Road,Lift to Mall,Christ Church,The Ridge,Jakhu Temple,Daulat Singh Park,Indian Institute of Advanced Study", "Shimla ", R.drawable.shimla));
        lines.add(new Info("Attractions:-Rohtang Pass,Solang Valley,Hidimba Devi Temple,Bhrigu Lake,Manali Sanctuary,Manu Temple,Manali Club House", "Manali", R.drawable.manali));

        InfoAdapter adapeter = new InfoAdapter(getActivity(),lines,R.color.category_places);
        ListView root = (ListView) rootView.findViewById(R.id.eventlist);
        root.setAdapter(adapeter);

return rootView;

    }

}
