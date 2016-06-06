package com.helveticagames.digi_class;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ended extends AppCompatActivity {
    public int resp = MainActivity.res_correct;
    public int cal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ended);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView res = (TextView) findViewById(R.id.R_correct);
        TextView cali = (TextView) findViewById(R.id.cal);
        Button back = (Button) findViewById(R.id.Back_mainMenu);
        setTitle("");

        if(resp == 5){
            cal = 10;
        }
        if(resp == 4){
            cal = 8;
        }
        if(resp == 3){
            cal = 6;
        }
        if(resp == 2){
            cal = 4;
        }
        if(resp == 1 ){
            cal = 2;
        }
        if(resp == 0){
            cal = 0;
        }
        res.setText("Respuestas correctas: " + resp);
        cali.setText("Calificacion: " + cal);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ended.this, Main_Menu.class);
                startActivity(intent);
                resp = 0;
                cal = 0;
                MainActivity.res_correct = 0;
                finish();


            }

        });


    }
    @Override
    public void onBackPressed(){

        //Do nothing
    }


}
