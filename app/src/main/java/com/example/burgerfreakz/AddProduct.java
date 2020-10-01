package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.burgerfreakz.Database.DBHelper;

public class AddProduct extends AppCompatActivity {
    EditText etName,etCode,etPrice,etSize;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        etName = (EditText) findViewById(R.id.etName);
        etCode = (EditText) findViewById(R.id.etCode);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etSize = (EditText) findViewById(R.id.etSize);
        add = findViewById(R.id.buttonSub);


        final DBHelper dbHandler = new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ProductName = etName.getText().toString();
                String ProductCode = etCode.getText().toString();
                String ProductPrice = etPrice.getText().toString();
                String ProductSize = etSize.getText().toString();

                Product product = new Product(ProductName,ProductCode,ProductPrice,ProductSize);

                Intent intent= new Intent(AddProduct.this,ProductList.class);
                startActivity(intent);


                long val = dbHandler.addProduct(product);

                if(val > 0){
                    Toast.makeText(AddProduct.this,"Product added sucessfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(AddProduct.this,"Product added Unsucessfully",Toast.LENGTH_LONG).show();
                }

            }
        });

    }


  /*public void addProduct(View view){
        DBHandler dbHandler = new DBHandler(this);

       long val = dbHandler.addProduct(etName.getText().toString(),etCode.getText().toString(),etPrice.getText().toString(),etSize.getText().toString());

       if(val > 0){
           Toast.makeText(this,"Product added sucessfully",Toast.LENGTH_LONG).show();
       }else{
           Toast.makeText(this,"Product added Unsucessfully",Toast.LENGTH_LONG).show();
       }
    } */


}

