package com.andres_lasso.test.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.andres_lasso.test.R;
import com.andres_lasso.test.model.ManagerDb;

public class Departamento extends AppCompatActivity {
    
    //declaro lo que voy a usar
    
    public EditText edt_name;
    public Button btn_guardar;
    public ManagerDb managerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento);
        
    //declaro las variables y hago que sean reconocidos por medio de un id
        edt_name = findViewById(R.id.edt_name);
        btn_guardar = findViewById(R.id.btn_guardar);
        
        //instaciar la clases que tiene la conexion
        managerDb = new ManagerDb(Departamento.this);
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

        String name = edt_name.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, "Debe ingresar los datos", Toast.LENGTH_SHORT).show();
            return;
        }
        long resultado = managerDb.insertData("Departamento", name);

        if (resultado > 0) {
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            edt_name.setText("");
        }
        else {
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        }
        
    }
}