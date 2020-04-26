package com.example.salesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salesmart.DataBase.DBHandler;

import java.util.List;

public class Edit_Product extends AppCompatActivity {


}































    /*EditText name,descrip,status,price;
    Button update,delete,cancel,search;

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
        //search= findViewById(R.id.buttonsearchEP);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        /*search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List user = dbHandler.readAllInfo(name.getText().toString());
                if (user.isEmpty()){
                    Toast.makeText(Edit_Product.this, "No Product", Toast.LENGTH_SHORT).show();
                    name.setText(null);
                }
                else {
                    Toast.makeText(Edit_Product.this, "Foud Product"+user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    name.setText(user.get(0).toString());
                    descrip.setText(user.get(1).toString());
                    status.setText(user.get(2).toString());
                    price.setText(user.get(3).toString());
                }




            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                Boolean Status = dbHandler.updateInfo(name.getText().toString(),descrip.getText().toString(),status.getText().toString(),price.getText().toString());
                if (Status) {
                    Toast.makeText(Edit_Product.this, "Product Updated", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(Edit_Product.this, " Updated Faild", Toast.LENGTH_SHORT).show();

                };


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.deleteInfo(name.getText().toString());

                Toast.makeText(Edit_Product.this, "Product Deleted", Toast.LENGTH_SHORT).show();
                name.setText(null);
                descrip.setText(null);
                status.setText(null);
                price.setText(null);


                Intent i = new Intent(getApplicationContext(),Admin_View.class);
                startActivity(i);

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Admin_View.class);
                startActivity(i);

            }
        });*/


