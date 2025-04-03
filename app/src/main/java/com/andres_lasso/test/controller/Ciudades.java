package com.andres_lasso.test.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.andres_lasso.test.R;
import com.andres_lasso.test.model.ManagerDb;

public class Ciudades extends AppCompatActivity {


    //declaro lo que voy a usar

    public EditText edt_id, edt_name;
    public Button btn_guardar;
    public ManagerDb managerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades);

        //declaro las variables y hago que sean reconocidos por medio de un id
        edt_name = findViewById(R.id.edt_name);
        btn_guardar = findViewById(R.id.btn_guardar);

        //instaciar la clases que tiene la conexion

        managerDb = new ManagerDb(Ciudades.this);
        //hago que el boton guarde los datos
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }

        });

    }

    //metodo para guardar los datos
    public void save() {
        //declaro una variable para guardar los datos
        String idStr = edt_id.getText().toString();
        String name = edt_name.getText().toString();
        if (idStr.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "Debe ingresar los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        //segun la ia es para que intente convertirlo a entero, la verdad no entnedi pero ya no se rompe 🐱
        int id = Integer.parseInt(idStr);

        // Inserta en la tabla seleccionada
        long resultado = managerDb.insertData("Ciudad", name);

        if (resultado > 0) {
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            edt_id.setText("");
            edt_name.setText("");
        }
        else {
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        }


    }
}