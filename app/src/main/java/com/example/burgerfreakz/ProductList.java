package com.example.burgerfreakz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.burgerfreakz.Adapters.ProductAdapter;
import com.example.burgerfreakz.Classes.Product;
import com.example.burgerfreakz.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private List<Product> products;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        add = findViewById(R.id.addpro);
        listView = findViewById(R.id.list);
        final DBHelper dbHandler = new DBHelper(this);
        products = new ArrayList<>();

        products = dbHandler.getAllProduct();

        ProductAdapter adapter = new ProductAdapter(ProductList.this, R.layout.singleproduct,products);

        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentadd = new Intent(ProductList.this, AddProduct.class);
                startActivity(intentadd);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Product product = products.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductList.this);
                builder.setTitle(product.getProName());
                builder.setMessage(product.getProPrice());
                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent3 = new Intent(ProductList.this,UpdateProduct.class);
                        intent3.putExtra("Id",String.valueOf(product.getId()));
                        startActivity(intent3);

                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dbHandler.deleteproduct(product.getId());
                        Intent intent2 = new Intent(ProductList.this, ProductList.class);
                        startActivity(intent2);

                    }
                });
                builder.setNeutralButton("MoreInfo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent4 = new Intent(ProductList.this,ProductMoreInfo.class);
                        intent4.putExtra("Id",String.valueOf(product.getId()));
                        startActivity(intent4);
                    }
                });
                builder.show();
            }
        });
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