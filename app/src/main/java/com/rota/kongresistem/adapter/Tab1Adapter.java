package com.rota.kongresistem.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rota.kongresistem.R;

public class Tab1Adapter extends ArrayAdapter<String> {


    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    //private final String[] baskan;

    public Tab1Adapter(Activity context, String[] maintitle,String[] subtitle) {
        super(context, R.layout.custom_list, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        //this.baskan=baskan;

    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.tab1_clock);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.tab1_title);
        /*TextView bskanText = rowView.findViewById(R.id.konusmaci_salon);*/
//        ImageView addfavorite = rowView.findViewById(R.id.img_favorite);

        titleText.setText(maintitle[position]);
        subtitleText.setText(subtitle[position]);
        /*bskanText.setText(baskan[position]);*/

/*        addfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getText = maintitle[position];
                Log.i("",getText);
            }
        });*/

        return rowView;

    };


}
