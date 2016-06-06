package com.helveticagames.digi_class;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //Tengo que comenzar esta madre desde 0 y cambiar todas las condiciones de calificacion
    public int in = 1,op;

    public String tit, cuerp;
    public static int res_correct = 0;
    public String pregunta, respuestaA,respuestaB,respuestaC,respuestaD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Conectar la base de datos
        final Questions_BD BDC = new Questions_BD(getApplicationContext());

        //Declaración de variables
        final TextView num_pre = (TextView) findViewById(R.id.Num_Pre);
        final TextView pre = (TextView) findViewById(R.id.Pre);
        final RadioButton r1 = (RadioButton) findViewById(R.id.Res_1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.Res_2);
        final RadioButton r3 = (RadioButton) findViewById(R.id.Res_3);
        final RadioButton r4 = (RadioButton) findViewById(R.id.Res_4);
        final Button next = (Button) findViewById(R.id.Btn_Next);
        final Button finish = (Button) findViewById(R.id.End);

        finish.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        //Llamar la variable de opción de examenes
        op = Examenes.op;
            switch (op) {

                case 0:
                    //Llamar la primer pregunta
                    setTitle("Español");
                    //Señalador de progreso
                    num_pre.setText("Pregunta: " + in + "/5" + op);
                    BDC.recuperarInfo(in).getID();
                    pregunta = BDC.recuperarInfo(in).getPRE();
                    respuestaA = BDC.recuperarInfo(in).getRESA();
                    respuestaB = BDC.recuperarInfo(in).getRESB();
                    respuestaC = BDC.recuperarInfo(in).getRESC();
                    respuestaD = BDC.recuperarInfo(in).getRESD();

                    //Mostrar los datos de la pregunta en la layout
                    pre.setText(pregunta);
                    r1.setText(respuestaA);
                    r2.setText(respuestaB);
                    r3.setText(respuestaC);
                    r4.setText(respuestaD);
                    break;
                case 1:
                    //Llamar la primer pregunta
                    setTitle("Geografia");
                    //Señalador de progreso
                    num_pre.setText("Pregunta: " + in + "/5" + op);
                    BDC.recuperarGeo(in).getID();
                    pregunta = BDC.recuperarGeo(in).getPRE();
                    respuestaA = BDC.recuperarGeo(in).getRESA();
                    respuestaB = BDC.recuperarGeo(in).getRESB();
                    respuestaC = BDC.recuperarGeo(in).getRESC();
                    respuestaD = BDC.recuperarGeo(in).getRESD();

                    //Mostrar los datos de la pregunta en la layout
                    pre.setText(pregunta);
                    r1.setText(respuestaA);
                    r2.setText(respuestaB);
                    r3.setText(respuestaC);
                    r4.setText(respuestaD);

                case 2:
                    //
        }




        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(in != 5) {
                    next.setVisibility(View.VISIBLE);
                }
                if(in == 5){finish.setVisibility(View.VISIBLE);}
            }
        });
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(in != 5) {
                    next.setVisibility(View.VISIBLE);
                }
                if(in == 5){finish.setVisibility(View.VISIBLE);}
            }
        });
        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(in != 5) {
                    next.setVisibility(View.VISIBLE);
                }
                if(in == 5){finish.setVisibility(View.VISIBLE);}
            }
        });
        r4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(in != 5) {
                    next.setVisibility(View.VISIBLE);
                }
                if(in == 5){finish.setVisibility(View.VISIBLE);}
            }
        });


        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (in == 5 && r2.isChecked()) {
                    res_correct = res_correct + 1;
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                    r4.setChecked(false);

                }
                in=1;
                Intent intent = new Intent(MainActivity.this, Ended.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //Reparar el boton
                op = Examenes.op;
                    if(op == 0) {
                        in++;
                        num_pre.setText("Pregunta: " + in + "/5 " + op);
                        BDC.recuperarInfo(in).getID();
                        pregunta = BDC.recuperarInfo(in).getPRE();
                        respuestaA = BDC.recuperarInfo(in).getRESA();
                        respuestaB = BDC.recuperarInfo(in).getRESB();
                        respuestaC = BDC.recuperarInfo(in).getRESC();
                        respuestaD = BDC.recuperarInfo(in).getRESD();

                        //Mostrar los datos de la pregunta en la layout
                        pre.setText(pregunta);
                        r1.setText(respuestaA);
                        r2.setText(respuestaB);
                        r3.setText(respuestaC);
                        r4.setText(respuestaD);
                    }else{
                        if(op == 1)
                        {
                            in++;
                            num_pre.setText("Pregunta: " + in + "/5 " + op);
                            BDC.recuperarGeo(in).getID();
                            pregunta = BDC.recuperarGeo(in).getPRE();
                            respuestaA = BDC.recuperarGeo(in).getRESA();
                            respuestaB = BDC.recuperarGeo(in).getRESB();
                            respuestaC = BDC.recuperarGeo(in).getRESC();
                            respuestaD = BDC.recuperarGeo(in).getRESD();

                            //Mostrar los datos de la pregunta en la layout
                            pre.setText(pregunta);
                            r1.setText(respuestaA);
                            r2.setText(respuestaB);
                            r3.setText(respuestaC);
                            r4.setText(respuestaD);


                        }

                    }






                r1.setChecked(false);
                r1.setSelected(false);
                r2.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);
                next.setVisibility(View.INVISIBLE);
            }


        });
    }
    public void msgAlerta(View view){
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(tit);
        alertDialog.setMessage(cuerp);
        alertDialog.show();


    }

    @Override
    public void onBackPressed(){

        //Do nothing
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
