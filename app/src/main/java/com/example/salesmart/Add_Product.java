package com.example.salesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salesmart.DataBase.DBHandler;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Add_Product extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
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
}
