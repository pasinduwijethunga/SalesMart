package com.example.salesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.salesmart.DataBase.DBHandler;

import java.sql.Array;
import java.util.ArrayList;

public class List_view extends AppCompatActivity {

    ListView prolist;
    ArrayList datalist;
    ArrayAdapter adapter;

    DBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        prolist = findViewById(R.id.proList);

            db = new DBHandler(getApplicationContext());
            datalist = (ArrayList) db.readAllInfo();

            adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,datalist);
            prolist.setAdapter(adapter);

            prolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String text = prolist.getItemAtPosition(position).toString();
                    Toast.makeText(List_view.this, "Product Name "+text, Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(),Edit_Product.class);
                    startActivity(i);
                }
            });
    }
}
