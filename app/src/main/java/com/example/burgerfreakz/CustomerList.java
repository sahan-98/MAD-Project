package com.example.burgerfreakz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.GLDebugHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.burgerfreakz.Adapters.CustomerAdapter;
import com.example.burgerfreakz.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class CustomerList extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private List<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        listView = findViewById(R.id.list);
        final DBHelper dbHelper = new DBHelper(this);
        customers = new ArrayList<>();

        customers = dbHelper.getAllCustomers();

        CustomerAdapter adapter = new CustomerAdapter(CustomerList.this, R.layout.singlecustomer, customers);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Customer customer = customers.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomerList.this);
                builder.setTitle(customer.getFname());
                builder.setMessage(customer.getAddress());
                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNeutralButton("more info", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent4 = new Intent(CustomerList.this,MoreInfo.class);
                        intent4.putExtra("Id",String.valueOf(customer.getId()));
                        startActivity(intent4);

                    }
                });
                builder.show();
            }
        });
    }
}
