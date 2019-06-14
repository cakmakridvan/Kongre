package com.rota.kongresistem.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rota.kongresistem.R;
import com.rota.kongresistem.model.etkinlikList.ModelEtkinlik;
import com.rota.kongresistem.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EtkinlikAdapter extends BaseAdapter {

    private ArrayList<ModelEtkinlik> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public EtkinlikAdapter(Context context, ArrayList<ModelEtkinlik> listData){

            layoutInflater = LayoutInflater.from(context);
            this.listData = listData;
            this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View v, ViewGroup vg) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.list_item_etkinlik, null);
            holder = new ViewHolder();
            holder.uName = (TextView) v.findViewById(R.id.txt_head);
            holder.uKod = (TextView) v.findViewById(R.id.txt_kodu);
            holder.uLocation = (TextView) v.findViewById(R.id.txt_location);
            holder.uAddress = v.findViewById(R.id.txt_address);
            holder.uWebsite = v.findViewById(R.id.txt_website);
            holder.uPanel = v.findViewById(R.id.txt_panel);
            holder.uStartDate = v.findViewById(R.id.txt_DateStart);
            holder.uEndDate = v.findViewById(R.id.txt_DateEnd);
            holder.ilogo = v.findViewById(R.id.img_logo);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
            holder.uName.setText(listData.get(position).getName());
            holder.uKod.setText(listData.get(position).getShort_name());
            holder.uLocation.setText(listData.get(position).getLocation());
            holder.uAddress.setText(listData.get(position).getAddress());
            holder.uWebsite.setText(listData.get(position).getWebsite());
            holder.uPanel.setText(listData.get(position).getPanel());
     //go Website
            holder.uWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent goURL = new Intent(Intent.ACTION_VIEW);
            goURL.setData(Uri.parse(listData.get(position).getWebsite()));
            context.startActivity(goURL);
            }
        });

     //go Panel
        holder.uPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent goPanel = new Intent(Intent.ACTION_VIEW);
             goPanel.setData(Uri.parse(listData.get(position).getPanel()));
             context.startActivity(goPanel);

            }
        });

     //Converting StartDate format to Particular Format
            String getStartDate = Utils.convertDate(listData.get(position).getStartDate());
            holder.uStartDate.setText(getStartDate);
     //Converting EndDate format to Particular Format
            String getEndDate = Utils.convertDate(listData.get(position).getEndDate());
            holder.uEndDate.setText(getEndDate);
     //Conveting Url to Image
            Picasso.get().load(listData.get(position).getLogo()).into(holder.ilogo);
            return v;
        }

    static class ViewHolder {
            TextView uName;
            TextView uKod;
            TextView uLocation;
            TextView uAddress;
            TextView uWebsite;
            TextView uPanel;
            TextView uStartDate;
            TextView uEndDate;
            ImageView ilogo;
    }
}
