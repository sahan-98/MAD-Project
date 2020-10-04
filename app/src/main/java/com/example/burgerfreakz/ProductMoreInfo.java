package com.example.burgerfreakz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.burgerfreakz.Classes.Product;
import com.example.burgerfreakz.Database.DBHelper;

public class ProductMoreInfo extends AppCompatActivity {
    TextView pname;
    TextView pcode;
    TextView pprice;
    TextView psize;
    private DBHelper dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_more_info);

        dbHandler = new DBHelper(ProductMoreInfo.this);

        pname = (TextView) findViewById(R.id.pname);
        pcode = (TextView) findViewById(R.id.pcode);
        pprice = (TextView) findViewById(R.id.pprice);
        psize = (TextView) findViewById(R.id.psize);


        final String id = getIntent().getStringExtra("Id");
        Product product = dbHandler.getProduct(Integer.parseInt(id));

        pname.setText(product.getProName());
        pcode.setText(product.getProCode());
        pprice.setText(product.getProPrice());
        psize.setText(product.getProSize());


        /*editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etname = etName.getText().toString();
                String etcode = etCode.getText().toString();
                String etprice = etPrice.getText().toString();
                String etsize = etSize.getText().toString();

                Product product = new Product(Integer.parseInt(id),etname,etcode,etprice,etsize);
                int state = dbHandler.updateProduct(product);
                Intent intentUPD = new Intent(ProductMoreInfo.this,ProductList.class);
                startActivity(intentUPD);
            }
        });*/

    }
    public void Panel(View view){
        Intent intent = new Intent(this, AdminPanel.class);
        startActivity(intent);
    }

    public void Home(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void AboutUs(View view){
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }
}