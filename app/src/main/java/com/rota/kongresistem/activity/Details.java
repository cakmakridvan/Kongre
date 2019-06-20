package com.rota.kongresistem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rota.kongresistem.R;

public class Details extends AppCompatActivity {

    private Bundle extras;
    private TextView clock,speaker,salon,konu,baskan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        extras = getIntent().getExtras();
        String getClock = extras.getString("clock");
        String getSpeakers = extras.getString("speakers");
        String getSalon = extras.getString("salon");
        String getKonu = extras.getString("konu");
        String getBaskan = extras.getString("baskan");

        clock = findViewById(R.id.detail_clock);
        speaker = findViewById(R.id.detail_spekaer);
        salon = findViewById(R.id.detail_salon);
        konu = findViewById(R.id.detail_konu);
        baskan = findViewById(R.id.detail_konusmaci);

        clock.setText(getClock);
        speaker.setText(getSpeakers);
        salon.setText(getSalon);
        konu.setText(getKonu);
        baskan.setText(getBaskan);
    }
}
