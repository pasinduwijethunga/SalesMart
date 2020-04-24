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

import java.sql.Array;
import java.util.ArrayList;

public class List_view extends AppCompatActivity {

    //ListView prolist;
    //ArrayList datalist;
    //ArrayAdapter adapter;

   //    DBHandler db;

    DatabaseReference databaseReference;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        databaseReference = FirebaseDatabase.getInstance().getReference("product");
        listView= findViewById(R.id.proList);
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
                                                    @Override
                                                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                                                        String value = dataSnapshot.getValue(Add_Product.class).toString();
                                                        arrayList.add(value);
                                                        arrayAdapter.notifyDataSetChanged();

                                                    }

                                                    @Override
                                                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                                    }

                                                    @Override
                                                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                                                    }

                                                    @Override
                                                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                                    }
                                                });
                                        }
            }


//
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
