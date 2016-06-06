package com.helveticagames.digi_class;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class Questions_BD extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "BDPreguntas.sqlite";
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;


    public Questions_BD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();


    }


    public Helper recuperarInfo(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id", "Pregunta", "RespuestaA", "RespuestaB", "RespuestaC","RespuestaD"};
        Cursor c = db.query("español", valores_recuperar, "id=" + id, null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Helper Español = new Helper(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5));
        db.close();
        c.close();
        return Español;
    }

    public Helper recuperarGeo(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id", "Pregunta", "RespuestaA", "RespuestaB", "RespuestaC","RespuestaD"};
        Cursor c = db.query("geografia", valores_recuperar, "id=" + id, null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Helper Geografia = new Helper(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5));
        db.close();
        c.close();
        return Geografia;
    }

}