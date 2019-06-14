package com.rota.kongresistem.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.rota.kongresistem.R;
import com.rota.kongresistem.adapter.EtkinlikAdapter;
import com.rota.kongresistem.model.etkinlikList.ModelEtkinlik;
import com.rota.kongresistem.sevices.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.paperdb.Paper;

public class EtkinlikBilgileri extends AppCompatActivity {

    private ListView lv;
    private ProgressDialog progressDialog;
    private EtkinlikBilgileriTask etkinlikBilgileriTask = null;
    private ArrayList<ModelEtkinlik> results;
    private ModelEtkinlik modelEtkinlik;
    private Toolbar toolbar;
    private TextView title;
    private ImageButton back_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etkinlik_bilgileri);
        Paper.init(EtkinlikBilgileri.this);

        toolbar = findViewById(R.id.toolbar_top_etkinlik);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.toolbar_title_etkinlik);
        title.setText(getResources().getString(R.string.etkinlik_listesi));

        back_btn = findViewById(R.id.back_button_etkinlik);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        progressDialog = new ProgressDialog(EtkinlikBilgileri.this);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setIndeterminate(true);
        lv = findViewById(R.id.user_list);

        String getToken = Paper.book().read("kongre_token");

        results = new ArrayList<>();
        modelEtkinlik = new ModelEtkinlik();

        etkinlikBilgileriTask = new EtkinlikBilgileriTask("50");
        etkinlikBilgileriTask.execute((Void) null);


/*        recyclerView = findViewById(R.id.recycler_etkinlikBilgileri);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(EtkinlikBilgileri.this));*/
    }

    @SuppressLint("StaticFieldLeak")
    public class EtkinlikBilgileriTask extends AsyncTask<Void, Object, Boolean> {

        private final String id;

        EtkinlikBilgileriTask(String id) {
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
            Result = Service.GetEtkinlik(id);

            if (!Result.equalsIgnoreCase("false")) {

                try {
                    JSONObject jsonObject = new JSONObject(Result);

                    JSONArray jsonArray = jsonObject.getJSONArray("etkinlik_bilgileri");
                    Log.i("jsonArray",""+jsonArray);

                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray1 = jsonObject1.getJSONArray("etkinlik_adi");
                    Log.i("jsonArray1",""+jsonArray1);
                    String get_etkinlikAdi = jsonArray1.getString(0);
                    Log.i("etkinlik_adi",get_etkinlikAdi);
                    modelEtkinlik.setName(get_etkinlikAdi);

                    JSONObject jsonObject2 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray2 = jsonObject2.getJSONArray("etkinlik_ingilizce_adi");
                    Log.i("jsonArray2",""+jsonArray2);
                    String get_etkinlikİngilizce_adi = jsonArray2.getString(0);
                    Log.i("etkinlikİngilizce_adi", get_etkinlikİngilizce_adi);
                    modelEtkinlik.setEng_name(get_etkinlikİngilizce_adi);

                    JSONObject jsonObject3 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray3 = jsonObject3.getJSONArray("etkinlik_kisa_adi");
                    Log.i("jsonArray3",""+jsonArray3);
                    String get_etkinlik_kisa_adi = jsonArray3.getString(0);
                    Log.i("etkinlik_kisa_adi", get_etkinlik_kisa_adi);
                    modelEtkinlik.setShort_name(get_etkinlik_kisa_adi);

                    JSONObject jsonObject4 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray4 = jsonObject4.getJSONArray("etkinlik_logo");
                    Log.i("jsonArray4",""+jsonArray4);
                    String get_etkinlik_logo = jsonArray4.getString(0);
                    Log.i("etkinlik_logo", get_etkinlik_logo);
                    modelEtkinlik.setLogo(get_etkinlik_logo);

                    JSONObject jsonObject5 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray5 = jsonObject5.getJSONArray("etkinlik_yeri");
                    Log.i("jsonArray5",""+jsonArray5);
                    String get_etkinlik_yeri = jsonArray5.getString(0);
                    Log.i("etkinlik_yeri", get_etkinlik_yeri);
                    modelEtkinlik.setLocation(get_etkinlik_yeri);

                    JSONObject jsonObject6 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray6 = jsonObject6.getJSONArray("etkinlik_adres");
                    Log.i("jsonArray6",""+jsonArray6);
                    String get_etkinlik_adres = jsonArray6.getString(0);
                    Log.i("etkinlik_adres", get_etkinlik_adres);
                    modelEtkinlik.setAddress(get_etkinlik_adres);

                    JSONObject jsonObject7 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray7 = jsonObject7.getJSONArray("etkinlik_website");
                    Log.i("jsonArray7",""+jsonArray7);
                    String get_etkinlik_website = jsonArray7.getString(0);
                    Log.i("etkinlik_website", get_etkinlik_website);
                    modelEtkinlik.setWebsite(get_etkinlik_website);

                    JSONObject jsonObject8 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray8 = jsonObject8.getJSONArray("etkinlik_panel");
                    Log.i("jsonArray8",""+jsonArray8);
                    String get_etkinlik_panel = jsonArray8.getString(0);
                    Log.i("etkinlik_panel", get_etkinlik_panel);
                    modelEtkinlik.setPanel(get_etkinlik_panel);

                    JSONObject jsonObject9 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray9 = jsonObject9.getJSONArray("etkinlik_baslangic_tarihi");
                    Log.i("jsonArray9",""+jsonArray9);
                    String get_etkinlik_baslangic_tarihi = jsonArray9.getString(0);
                    Log.i("etkn_baslangic_tarihi", get_etkinlik_baslangic_tarihi);
                    modelEtkinlik.setStartDate(get_etkinlik_baslangic_tarihi);

                    JSONObject jsonObject10 = jsonArray.getJSONObject(0);
                    JSONArray jsonArray10 = jsonObject10.getJSONArray("etkinlik_bitis_tarihi");
                    Log.i("jsonArray10",""+jsonArray10);
                    String get_etkinlik_bitis_tarihi = jsonArray10.getString(0);
                    Log.i("etkn_bitis_tarihi", get_etkinlik_bitis_tarihi);
                    modelEtkinlik.setEndDate(get_etkinlik_bitis_tarihi);

                    results.add(modelEtkinlik);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }else{

            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            etkinlikBilgileriTask = null;
            progressDialog.dismiss();

            lv.setAdapter(new EtkinlikAdapter(EtkinlikBilgileri.this,results));
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

/*                    ModelEtkinlik user = (ModelEtkinlik) lv.getItemAtPosition(position);
                    Toast.makeText(EtkinlikBilgileri.this, "Selected :" + " " + user.getName()+", "+ user.getLocation(), Toast.LENGTH_SHORT).show();*/
                }
            });

        }

        @Override
        protected void onCancelled() {
            etkinlikBilgileriTask = null;
            progressDialog.dismiss();
        }

    }
}
