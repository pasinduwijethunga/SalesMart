package com.example.salesmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.salesmart.ViewHolder.Product_View_Holder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    private DatabaseReference ProductRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private DatabaseReference mDatabase;
    private ListView ProList;
    String ID;


    private ArrayList<String> pro = new ArrayList<>();
    private ArrayList<Product> delList = new ArrayList<>();

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_all);
 /*
        ProductRef = FirebaseDatabase.getInstance().getReference().child("products");





        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     /*   FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });/////////
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery)
                .setDrawerLayout(drawer)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
 /*
    @Override
    public boolean onSupportNavigateUp() {
       NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
        || super.onSupportNavigateUp();



*/


        mDatabase = FirebaseDatabase.getInstance().getReference().child("products");
        ProList = (ListView) findViewById(R.id.listproduct);



        mDatabase.addValueEventListener(new ValueEventListener() {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Home.this, android.R.layout.simple_list_item_1,pro);

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pro.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Product pro1 = ds.getValue(Product.class);




                    //HashMap<String, Object> productMap = ds.getValue(HashMap.class);
                    String name = pro1.getPname();

                    //String id = "Default";
                    ID = pro1.getDate();

                    delList.add(pro1);
                    pro.add(name);


                }
                ProList.setAdapter(arrayAdapter);

                ProList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String id1 = pro.get(position);

                       Intent intent = new Intent(Home.this, Edit_Product.class);
                       intent.putExtra("id", ID);

                        startActivity(intent);

                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    }
/*
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>()
                .setQuery(ProductRef,Product.class).build();

        FirebaseRecyclerAdapter <Product, Product_View_Holder> adapter=
                new FirebaseRecyclerAdapter<Product, Product_View_Holder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull Product_View_Holder  holder, int i, @NonNull Product model) {

                        holder.txtpname.setText(model.getPname());
                        holder.txtpdescrip.setText(model.getDescription());
                        holder.txtpstatus.setText(model.getStatus());
                        holder.txtpprice.setText("Rs "+model.getPrice() );
                        Picasso.get().load(model.getImage()).into(holder.imgview);

                    }

                    @NonNull
                    @Override
                    public Product_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_layout,parent,false);
                        Product_View_Holder holder = new Product_View_Holder(view);
                        return holder;



                    }
                };

            recyclerView.setAdapter((adapter));
            adapter.startListening();

    }




}*/
