package com.rota.kongresistem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.rota.kongresistem.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class SergiFirmalari extends AppCompatActivity {

    private ImageView sergiPhoto;
    private PhotoViewAttacher pAttacher;
    private Toolbar toolbar;
    private TextView title;
    private ImageButton back_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sergi_firmalari);
        sergiPhoto = findViewById(R.id.imgView_sergiphoto);

    //Zoom in and Zoom out function
        pAttacher = new PhotoViewAttacher(sergiPhoto);
        pAttacher.update();

        toolbar = findViewById(R.id.toolbar_top_sergi_firmalari);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.toolbar_title_sergi_firmalari);
        title.setText(getResources().getString(R.string.name_exhibition));

        back_btn = findViewById(R.id.back_button_sergi_firmalari);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
