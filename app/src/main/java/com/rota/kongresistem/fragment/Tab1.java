package com.rota.kongresistem.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.rota.kongresistem.R;
import com.rota.kongresistem.adapter.Tab1Adapter;


public class Tab1 extends Fragment implements View.OnClickListener {

    private ListView listView;
    private Button btn1,btn2;
    View inflate;
    private TextView title;

    String[] txt_clock ={
            "10:00-10:40",
            "10:40-11:00","11:00-11:20",
            "11:20-11:40","11:40-12:00"
    };

    String[] txt_title ={
            "AÇILIŞ SUNUMLARI","ŞÜKRÜ ERSOY, ÖZCAN ERDOĞAN, FİLİZ KATMAN, SERHAT YILMAZ (9731)",
            "REZA SABER, VEYSEL IŞIK, AYŞE ÇAĞLAYAN (9897)","EFNAN ŞORA GÜNAL, UĞUR GÜREL (9907)",
            "ŞENER CERYAN (9959)"
    };

    String[] txt_clock2 ={
            "10:00-10:40"
    };

    String[] txt_title2 ={
            "AÇILIŞ SUNUMLARI"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        inflate = inflater.inflate(R.layout.fragment_tab1, container, false);

        btn1 = inflate.findViewById(R.id.btn1);
        btn2 = inflate.findViewById(R.id.btn2);
        title = inflate.findViewById(R.id.title_salon);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        Tab1Adapter tab1Adapter = new Tab1Adapter(getActivity(),txt_clock,txt_title);
        listView = inflate.findViewById(R.id.list_tab1);
        listView.setAdapter(tab1Adapter);

        title.setText("Salon 3");

        return inflate;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.btn1:

                title.setText("Salon 3");

                Tab1Adapter tab1Adapter = new Tab1Adapter(getActivity(),txt_clock,txt_title);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter);

                break;

            case R.id.btn2:

                title.setText("Salon 5");

                Tab1Adapter tab1Adapter2 = new Tab1Adapter(getActivity(),txt_clock2,txt_title2);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter2);

                break;
        }
    }
}
