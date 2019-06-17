package com.rota.kongresistem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rota.kongresistem.R;

public class About extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView title;
    private ImageButton back_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        toolbar = findViewById(R.id.toolbar_top_about);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.toolbar_title_about);
        title.setText(getResources().getString(R.string.name_about));

        back_btn = findViewById(R.id.back_button_about);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
