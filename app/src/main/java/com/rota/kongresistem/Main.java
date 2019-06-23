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
import android.widget.Toast;

import com.rota.kongresistem.activity.About;
import com.rota.kongresistem.activity.BildiriBilgileri;
import com.rota.kongresistem.activity.EtkinlikBilgileri;
import com.rota.kongresistem.activity.KatilimciBilgilendirme;
import com.rota.kongresistem.activity.Program;
import com.rota.kongresistem.activity.SergiFirmalari;
import com.rota.kongresistem.activity.SummarySending;
import com.rota.kongresistem.adapter.BildiriAdapter;
import com.rota.kongresistem.login.Login;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import io.paperdb.Paper;

public class Main extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_etkinlik_listesi)
    ImageButton etkinlikListesi;
    @BindView(R.id.btn_etkinlik_bildiri)
    ImageButton etkinlikBildiri;
    @BindView(R.id.btn_about)
    ImageButton about;
    @BindView(R.id.btn_summary)
    ImageButton summary;
    @BindView(R.id.btn_kongre_takvim)
    ImageButton kongre_takvim;
    @BindView(R.id.btn_sponsor)
    ImageButton sponsorlar;
    @BindView(R.id.btn_exhibition)
    ImageButton exhibition;
    @BindView(R.id.btn_info)
    ImageButton duyurular;
    @BindView(R.id.btn_user_info)
    ImageButton katilimci_bilgilendirme;

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
        about.setOnClickListener(this);
        summary.setOnClickListener(this);
        kongre_takvim.setOnClickListener(this);
        sponsorlar.setOnClickListener(this);
        exhibition.setOnClickListener(this);
        duyurular.setOnClickListener(this);
        katilimci_bilgilendirme.setOnClickListener(this);
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

            case R.id.btn_about:

                Intent go_about = new Intent(Main.this,About.class);
                startActivity(go_about);

                break;

            case R.id.btn_summary:

                Intent go_summary = new Intent(Main.this,SummarySending.class);
                startActivity(go_summary);

                break;

            case R.id.btn_kongre_takvim:

                /*Toast.makeText(Main.this,"Yakında eklenecektir..",Toast.LENGTH_SHORT).show();*/
                Intent go_kongre = new Intent(Main.this,Program.class);
                startActivity(go_kongre);

                break;

            case R.id.btn_sponsor:

                Toast.makeText(Main.this,"Yakında eklenecektir..",Toast.LENGTH_SHORT).show();

                break;

            case R.id.btn_exhibition:

                Intent go_sergi_firmalari = new Intent(Main.this,SergiFirmalari.class);
                startActivity(go_sergi_firmalari);

                break;

            case R.id.btn_info:

                Toast.makeText(Main.this,"Yakında eklenecektir..",Toast.LENGTH_SHORT).show();

                break;

            case R.id.btn_user_info:

                Intent go_katilimci_bilgi = new Intent(Main.this,KatilimciBilgilendirme.class);
                startActivity(go_katilimci_bilgi);
                break;

            case R.id.app_exit:

                new SweetAlertDialog(Main.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText(getString(R.string.uygulama_cikis))
                        .setContentText(getString(R.string.hesap_degistir))
                        .setCancelText(getString(R.string.iptal))
                        .setConfirmText(getString(R.string.hesap_cikis))
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {

                                Paper.book().delete("kongre_token");

                                Process.killProcess(Process.myPid());
                                System.exit(1);

                            }
                        })
                        .show();

                break;
        }
    }
}
