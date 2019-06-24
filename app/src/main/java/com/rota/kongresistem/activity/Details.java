package com.rota.kongresistem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rota.kongresistem.R;

public class Details extends AppCompatActivity {

    private Bundle extras;
    private TextView clock,speaker,salon,konu,baskan;
    private Toolbar toolbar;
    private TextView title;
    private ImageButton back_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.toolbar_title_detail);
        title.setText(getResources().getString(R.string.detail));

        back_btn = findViewById(R.id.back_button_detail);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        extras = getIntent().getExtras();
        String getClock = extras.getString("clock");
        String getSpeakers = extras.getString("speakers");
        String getSalon = extras.getString("salon");
        String getKonu = extras.getString("konu");
        //String getBaskan = extras.getString("baskan");

        clock = findViewById(R.id.detail_clock);
        speaker = findViewById(R.id.detail_spekaer);
        salon = findViewById(R.id.detail_salon);
        konu = findViewById(R.id.detail_konu);
        //baskan = findViewById(R.id.detail_konusmaci);

        clock.setText(getClock);
        speaker.setText(getSpeakers);
        salon.setText(getSalon);
        konu.setText(getKonu);
        //baskan.setText(getBaskan);
    }
}
