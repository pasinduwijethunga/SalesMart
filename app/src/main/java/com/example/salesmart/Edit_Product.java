package com.example.salesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_Product extends AppCompatActivity {

    EditText name,descrip,status,price;
    Button update,delete,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__product);

        name = findViewById(R.id.editTextNameEP);
       descrip = findViewById(R.id.editTextDescripEP);
        status = findViewById(R.id.editTextStsEP);
        price = findViewById(R.id.editTextPriceEP);
        update= findViewById(R.id.btnUPEP);
        delete= findViewById(R.id.btnDeleteEP);
        cancel= findViewById(R.id.btnCnclEP);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Admin_View.class);
                startActivity(i);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Admin_View.class);
                startActivity(i);

            }
        });

    }
}
