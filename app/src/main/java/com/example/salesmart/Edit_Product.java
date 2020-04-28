package com.example.salesmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Edit_Product extends AppCompatActivity {
    TextView editTextNameEP, editTextDescripEP, editTextStsEP, editTextPriceEP;
    DatabaseReference ProductRef;
    private ImageView img;
    Button btnUPEP;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit__product);

        editTextNameEP = findViewById(R.id.editTextNameEP);
        editTextDescripEP = findViewById(R.id.editTextDescripEP);
        editTextStsEP = findViewById(R.id.editTextStsEP);
        editTextPriceEP = findViewById(R.id.editTextPriceEP);
        img = (ImageView) findViewById(R.id.imageViewAP);
        btnUPEP = (Button) findViewById(R.id.btnUPEP);

        OnStart();


    }

    public void OnStart() {
        super.onStart();
        Bundle extras = getIntent().getExtras();

        String pid = extras.getString("id");

        System.out.println();

        ProductRef = FirebaseDatabase.getInstance().getReference().child("products").child(pid);
        ProductRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Product pr = dataSnapshot.getValue(Product.class);

                editTextNameEP.setText(pr.getPname());
                editTextDescripEP.setText(pr.getDescription());
                editTextStsEP.setText(pr.getStatus());
                editTextPriceEP.setText(pr.getPrice());
                // img.get(pr.getImage());
                //id = pr.getId();
                //Picasso.get().load(pr.get(position).getImage).into(holder.pr);
            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnUPEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });


    }


}


    /*public  void  update(View view){
        if(isNameChange() || isDescrictionChange() || isPriceChange() || isStatusChange()){

            Toast.makeText(this, "Updated Successfully......", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean isStatusChange() {

        return true;

    }

    private boolean isPriceChange() {
        return true;
    }

    private boolean isDescrictionChange() {
        return true;
    }

    private boolean isNameChange() {

        if (editTextNameEP == editTextNameEP){

            ProductRef.child("pname").setValue(editTextNameEP);
            editTextNameEP = editTextNameEP;

            return  true;
        }
        else {
            return false;
        }
    }
}*/































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


