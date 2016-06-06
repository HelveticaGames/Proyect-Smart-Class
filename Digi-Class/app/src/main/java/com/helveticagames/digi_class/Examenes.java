package com.helveticagames.digi_class;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class Examenes extends AppCompatActivity {
    public static int op  = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examenes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton Esp = (ImageButton) findViewById(R.id.Español);
        ImageButton Geo = (ImageButton) findViewById(R.id.Geo);
        ImageButton CN = (ImageButton) findViewById(R.id.Cn);


        Esp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = 0;
                Intent esp = new Intent(Examenes.this, MainActivity.class);
                startActivity(esp);

            }
        });
        Geo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                op = 1;
                Intent geo = new Intent(Examenes.this, MainActivity.class);
                startActivity(geo);


            }
        });
        CN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                op = 2;
                Intent cn = new Intent(Examenes.this, MainActivity.class);
                startActivity(cn);

            }
        });
    }
    @Override
    public void onBackPressed(){

        //Do nothing
    }

}
