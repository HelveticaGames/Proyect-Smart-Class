package com.helveticagames.digi_class;

/**
 * Created by Ramiro123 on 03/06/2016.
 */
public class Helper {
    private int id;
    private String pregunta, respuestaA, respuestaB, respuestaC,respuestaD;



    public Helper(int id, String Pregunta, String respuestaa, String respuestab, String respuestac, String respuestad)
    {
        this.id = id;
        this.pregunta = Pregunta;
        this.respuestaA = respuestaa;
        this.respuestaB = respuestab;
        this.respuestaC = respuestac;
        this.respuestaD = respuestad;
    }

    //Recuperar pregunta y respuestas
    public int getID(){ return id; }
    public String getPRE(){ return pregunta; }
    public String getRESA(){ return respuestaA; }
    public String getRESB(){
        return respuestaB;
    }
    public String getRESC(){
        return respuestaC;
    }
    public String getRESD(){
        return respuestaD;
    }

}

