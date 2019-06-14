package com.rota.kongresistem;

import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rota.kongresistem.activity.BildiriBilgileri;
import com.rota.kongresistem.activity.EtkinlikBilgileri;
import com.rota.kongresistem.adapter.BildiriAdapter;
import com.rota.kongresistem.login.Login;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_etkinlik_listesi)
    Button etkinlikListesi;
    @BindView(R.id.btn_etkinlik_bildiri)
    Button etkinlikBildiri;

    @BindView(R.id.toolbar_top_main)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title_main)
    TextView title;
    @BindView(R.id.app_exit)
    ImageButton btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(Main.this);

        setSupportActionBar(toolbar);
        title.setText(getResources().getString(R.string.app_name));

        etkinlikListesi.setOnClickListener(this);
        etkinlikBildiri.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_etkinlik_listesi:

                Intent go_etkinlikBilgileri = new Intent(Main.this,EtkinlikBilgileri.class);
                startActivity(go_etkinlikBilgileri);

                break;

            case R.id.btn_etkinlik_bildiri:

                Intent go_bildiriBilgileri = new Intent(Main.this,BildiriBilgileri.class);
                startActivity(go_bildiriBilgileri);

                break;

            case R.id.app_exit:

                Process.killProcess(Process.myPid());
                System.exit(1);

                break;
        }
    }
}
