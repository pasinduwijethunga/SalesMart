package com.example.salesmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salesmart.DataBase.DBHandler;
import com.example.salesmart.DataBase.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Add_Product extends AppCompatActivity {

        EditText name,descrip,status,price;
        Button add,cancel;
        FirebaseDatabase database;
        DatabaseReference reference;
        ProductHelperClass ProductHelperClass;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__product);

        name = (EditText) findViewById(R.id.editTextNameAP);
        descrip = (EditText) findViewById(R.id.editTextDescripAP);
        status = (EditText) findViewById(R.id.editTextStsAP);
        price = (EditText) findViewById(R.id.editTextPriceAP);
        add = (Button) findViewById(R.id.btnAddAP);
        cancel = (Button) findViewById(R.id.btnCncleAP);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("product");
        ProductHelperClass = new ProductHelperClass();


    }
    private void getValues() {

        ProductHelperClass.setpName(name.getText().toString());
        ProductHelperClass.setpDescription(name.getText().toString());
        ProductHelperClass.setpStatus(name.getText().toString());
        ProductHelperClass.setpPrice(name.getText().toString());



    }

    public void btnAddAP (View view) {

    reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            getValues();
            reference.child("product01").setValue(ProductHelperClass);
            Toast.makeText(Add_Product.this, "Added SuccessFully", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });

    }


    }






    /*FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    EditText name,descrip,status,price;
    Button add,cancel;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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


                //DBHandler dbHandler = new DBHandler(getApplicationContext());
                //long newID=     dbHandler.addInfo(name.getText().toString(),descrip.getText().toString(),status.getText().toString(),price.getText().toString());
                //Toast.makeText(Add_Product.this,"Product Added. Product ID"+newID,Toast.LENGTH_SHORT).show();



                //name.setText(null);
                //descrip.setText(null);
                //status.setText(null);
                //price.setText(null);
                String prName = name.getText().toString().trim();
                String prDescription = descrip.getText().toString().trim();
                String prStatus = status.getText().toString().trim();
                String prPrice = price.getText().toString().trim();

                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("product");
                ProductHelperClass productHelperClass = new ProductHelperClass(prName, prDescription, prStatus, prPrice);
                reference.child(prName).setValue(productHelperClass);



                Intent i = new Intent(getApplicationContext(),List_view.class);
                startActivity(i);





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
}*/
