package com.andres_lasso.test.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//extiendo la clase SQLiteOpenHelper
public class DbHelper  extends SQLiteOpenHelper {

// hago un contrucor
public DbHelper(Context context) {
    super(context, Constants.DB_NAME, null, Constants.NAME_VERSION);
    }

    //ahora pongo lo que se va a ejecutar la primera vez que se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //esto crea la tabla ciudad
        db.execSQL(Constants.SENETENCIACIUDAD);
        //esto crea la tabla datos
        db.execSQL(Constants.SENTENCEDATOS);
        //esto crea la tabla barrios
        db.execSQL(Constants.SENTENCEBARRIOS);
        //esto crea la tabla departamento
        db.execSQL(Constants.SENTENCEDEPARTAMENTO);
    }

    //ahora lo que se ejecuta en cada actualizacion de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //esto elimina la tabla ciudad si existe
        db.execSQL("DROP TABLE IF EXISTS Ciudad");
        //esto elimina la tabla datos si existe
        db.execSQL("DROP TABLE IF EXISTS Datos");
        //esto elimina la tabla barrios si existe
        db.execSQL("DROP TABLE IF EXISTS Barrios");
        //esto elimina la tabla departamento si existe
        db.execSQL("DROP TABLE IF EXISTS Departamento");
        //llamo al metodo onCreate para crear las tablas nuevamente
        onCreate(db);
    }
}