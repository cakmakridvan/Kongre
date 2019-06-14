package com.rota.kongresistem.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.rota.kongresistem.R;
import com.rota.kongresistem.model.bildiriList.ModelBildiri;

import java.util.ArrayList;
import java.util.List;

public class BildiriAdapter extends RecyclerView.Adapter<BildiriAdapter.ViewHolder> implements Filterable {

    private List<ModelBildiri> listData;
    private List<ModelBildiri> listData_search;
    private ModelBildiri modelBildiri;
    private LayoutInflater layoutInflater;
    private Context context;

    public BildiriAdapter(Context context, ArrayList<ModelBildiri> listData){

        this.context = context;
        this.listData = listData;
        listData_search = new ArrayList<>(listData);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_bildiri,viewGroup,false);
        //Progress Diaolog initialize

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        modelBildiri = listData.get(i);
        viewHolder.uNo.setText(modelBildiri.getNo());
        viewHolder.uKonu.setText(modelBildiri.getKonusu());
        viewHolder.uTuru.setText(modelBildiri.getTuru());
        viewHolder.uBasligi.setText(modelBildiri.getBasligi());
        viewHolder.uYazarBilgileri.setText(modelBildiri.getYazarBilgileri());
        viewHolder.uBildiriDurumu.setText(modelBildiri.getBildiriDurumu());


    }
    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView uNo;
        TextView uKonu;
        TextView uTuru;
        TextView uBasligi;
        TextView uYazarBilgileri;
        TextView uBildiriDurumu;

        public ViewHolder(View itemView) {
            super(itemView);

            uNo = itemView.findViewById(R.id.txt_no);
            uKonu = itemView.findViewById(R.id.txt_konusu);
            uTuru = itemView.findViewById(R.id.txt_turu);
            uBasligi = itemView.findViewById(R.id.txt_basligi);
            uYazarBilgileri = itemView.findViewById(R.id.txt_yazar_bilgileri);
            uBildiriDurumu = itemView.findViewById(R.id.txt_durumu);
        }
    }

    //for SearchView in RecyclerView
    @Override
    public Filter getFilter() {
        return list_allmesaj_filter;
    }

    private Filter list_allmesaj_filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<ModelBildiri> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){

                filteredList.addAll(listData_search);
            }else{

                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ModelBildiri item : listData_search ){

                    if(item.getKonusu().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            listData.clear();
            listData.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
