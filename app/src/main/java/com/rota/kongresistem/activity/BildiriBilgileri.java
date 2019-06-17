package com.rota.kongresistem.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rota.kongresistem.R;
import com.rota.kongresistem.adapter.BildiriAdapter;
import com.rota.kongresistem.model.bildiriList.ModelBildiri;
import com.rota.kongresistem.sevices.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BildiriBilgileri extends AppCompatActivity{

    private ProgressDialog progressDialog;
    private BildiriBilgileriTask bildiriBilgileriTask;
    private RecyclerView recyclerView;
    private ModelBildiri modelBildiri;
    private ArrayList<ModelBildiri> dataList;
    private Toolbar toolbar;
    private TextView title;
    private ImageButton back_btn;
    private BildiriAdapter adap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bildiri_bilgileri);

        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.toolbar_title);
        title.setText(getResources().getString(R.string.bildiri_listesi));

        back_btn = findViewById(R.id.back_button);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        progressDialog = new ProgressDialog(BildiriBilgileri.this);
        progressDialog.setIndeterminate(true);

        recyclerView = findViewById(R.id.bildiri_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(BildiriBilgileri.this));

        dataList = new ArrayList<>();


        bildiriBilgileriTask = new BildiriBilgileriTask("50");
        bildiriBilgileriTask.execute((Void) null);
    }



    @SuppressLint("StaticFieldLeak")
    public class BildiriBilgileriTask extends AsyncTask<Void, Object, Boolean> {

        private final String id;

        BildiriBilgileriTask(String id) {
            this.id = id;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage(getResources().getString(R.string.loading));
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            String Result = "false";
            // Simulate network access.
            Result = Service.GetBildiri(id);

            if (!Result.equalsIgnoreCase("false")) {

                try {
                    JSONObject jsonObject = new JSONObject(Result);
                    JSONArray jsonArray = jsonObject.getJSONArray("bildiri_bilgileri");
                    Log.i("jsonArray",""+jsonArray);

                 for(int i = 0 ; i < jsonArray.length(); i++) {

                     modelBildiri = new ModelBildiri();

                     JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                     JSONArray jsonArray1 = jsonObject1.getJSONArray("bildiri_no");
                     Log.i("jsonArray1", "" + jsonArray1);
                     String get_bildiriNo = jsonArray1.getString(0);
                     Log.i("bildiriNo", get_bildiriNo);
                     modelBildiri.setNo(get_bildiriNo);

                     JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                     JSONArray jsonArray2 = jsonObject2.getJSONArray("bildiri_konusu");
                     Log.i("jsonArray2", "" + jsonArray2);
                     String get_bildiriKonu = jsonArray2.getString(0);
                     Log.i("bildiriKonu", get_bildiriKonu);
                     modelBildiri.setKonusu(get_bildiriKonu);

                     JSONObject jsonObject3 = jsonArray.getJSONObject(i);
                     JSONArray jsonArray3 = jsonObject3.getJSONArray("bildiri_turu");
                     Log.i("jsonArray3", "" + jsonArray3);
                     String get_bildiriTuru = jsonArray3.getString(0);
                     Log.i("bildiriTuru", get_bildiriTuru);
                     modelBildiri.setTuru(get_bildiriTuru);

                     JSONObject jsonObject4 = jsonArray.getJSONObject(i);
                     JSONArray jsonArray4 = jsonObject4.getJSONArray("bildiri_basligi");
                     Log.i("jsonArray4", "" + jsonArray4);
                     String get_bildiriBasligi = jsonArray4.getString(0);
                     Log.i("bildiriBasligi", get_bildiriBasligi);
                     modelBildiri.setBasligi(get_bildiriBasligi);

                     JSONObject jsonObject5 = jsonArray.getJSONObject(i);
                     JSONArray jsonArray5 = jsonObject5.getJSONArray("yazar_bilgileri");
                     Log.i("jsonArray5", "" + jsonArray5);
                     String get_yazarBilgileri = jsonArray5.getString(0);
                     Log.i("yazarBilgileri", get_yazarBilgileri);
                     modelBildiri.setYazarBilgileri(get_yazarBilgileri);

                     JSONObject jsonObject6 = jsonArray.getJSONObject(i);
                     JSONArray jsonArray6 = jsonObject6.getJSONArray("bildiri_durumu");
                     Log.i("jsonArray6", "" + jsonArray6);
                     String get_bildiri_durumu = jsonArray6.getString(0);
                     Log.i("bildiri_durumu", get_bildiri_durumu);
                     modelBildiri.setBildiriDurumu(get_bildiri_durumu);

                     dataList.add(modelBildiri);

                 }

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }else{

            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            bildiriBilgileriTask = null;
            progressDialog.dismiss();

            adap = new BildiriAdapter(BildiriBilgileri.this,dataList);
            recyclerView.setAdapter(adap);
         //for SearchView in RecyclerView



        }

        @Override
        protected void onCancelled() {
            bildiriBilgileriTask = null;
            progressDialog.dismiss();
        }

    }


    //For Search RecyclerView Button for Message
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search2);

        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adap.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}
