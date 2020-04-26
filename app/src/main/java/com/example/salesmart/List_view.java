package com.example.salesmart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import java.util.List;

public class List_view extends AppCompatActivity {

}


































    /*ListView prolist;
    //ArrayList datalist;
    //ArrayAdapter adapter;

    //    DBHandler db;

        private RecyclerView pRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        pRecyclerView = findViewById(R.id.rv_list);

        new FireBaseHelperClass().readProductDetails(new FireBaseHelperClass.DataStatus() {
            @Override
            public void dataIsLoad(List<ProductHelperClass> product, List<String> keys) {
                new RecyclerViewConfig().setConfig(pRecyclerView, List_view.this, product, keys );
            }

            @Override
            public void dataIsInserted() {

            }

            @Override
            public void dataIsUpdated() {

            }

            @Override
            public void dataIsDeleted() {

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
}*/
