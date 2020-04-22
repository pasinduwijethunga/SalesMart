package com.example.salesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.salesmart.DataBase.DBHandler;

public class Add_Product extends AppCompatActivity {

    EditText name,descrip,status,price;
    Button add,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__product);

        name = findViewById(R.id.editTextNameAP);
        descrip = findViewById(R.id.editTextDescripAP);
        status = findViewById(R.id.editTextStsAP);
        price = findViewById(R.id.editTextPriceAP);
        add = findViewById(R.id.btnAddAP);
        cancel = findViewById(R.id.btnCncleAP);

       add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Admin_View.class);
                startActivity(i);

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.addInfo(name.getText().toString(),descrip.getText().toString(),status.getText().toString(),price.getText().toString());

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Admin.class);
                startActivity(i);

            }
        });

    }
}
