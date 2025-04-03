package com.andres_lasso.test.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.andres_lasso.test.R;
import com.andres_lasso.test.model.DbHelper;

public class MainActivity extends AppCompatActivity {



    Button btn_ciudades, btn_barrios, btn_departamentos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn_ciudades = findViewById(R.id.btn_ciudades);
        btn_barrios = findViewById(R.id.btn_barrios);
        btn_departamentos = findViewById(R.id.btn_departamentos);

    btn_ciudades.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Ciudades.class);
            startActivity(intent);
        }
    });

    btn_barrios.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Barrios.class);
            startActivity(intent);
        }
    });

    btn_departamentos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ontent = new Intent(MainActivity.this, Departamento.class);
            startActivity(ontent);
        }
    });

    }
}