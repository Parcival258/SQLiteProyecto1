package com.andres_lasso.test.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andres_lasso.test.R;
import com.andres_lasso.test.model.ManagerDb;

public class Barrios extends AppCompatActivity {

    private EditText edt_name;
    private Button btn_guardar;
    public ManagerDb managerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barrios);

    edt_name = findViewById(R.id.edt_name);
    btn_guardar = findViewById(R.id.btn_guardar);

    managerDb = new ManagerDb(Barrios.this);

    btn_guardar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save();
        }
    });

    }

    public void save() {
        String name = edt_name.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, "Debe ingresar los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        long resultado = managerDb.insertData("Barrios", name);

        if (resultado > 0) {
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            edt_name.setText("");
        } else {
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        }

    }
}