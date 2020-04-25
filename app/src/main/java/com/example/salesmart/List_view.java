package com.example.salesmart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.salesmart.DataBase.DBHandler;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;

public class List_view extends AppCompatActivity {

    //ListView prolist;
    //ArrayList datalist;
    //ArrayAdapter adapter;

    //    DBHandler db;

    FirebaseDatabase database;
    DatabaseReference ref;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;
    ProductHelperClass productHelperClass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        productHelperClass = new ProductHelperClass();
        database = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference("product");
        list =new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.product_info, R.id.productInfo, list);
        listView = (ListView) findViewById(R.id.listView);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                        productHelperClass = ds.getValue(ProductHelperClass.class);
                        list.add(productHelperClass.getpName());
                }
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        Intent i = new Intent(getApplicationContext(),Edit_Product.class);
                        startActivity(i);
                    }
                });
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }




        });





        //prolist = findViewById(R.id.proList);

        //db = new DBHandler(getApplicationContext());
        //datalist = (ArrayList) db.readAllInfo();

        //adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,datalist);
        //prolist.setAdapter(adapter);

        //prolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        // @Override
        // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
        //  String text = prolist.getItemAtPosition(position).toString();
        //  Toast.makeText(List_view.this, "Product Name "+text, Toast.LENGTH_SHORT).show();

        //  Intent i = new Intent(getApplicationContext(),Edit_Product.class);
        // startActivity(i);*
        //}
        //});
    }
}