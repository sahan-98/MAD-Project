package com.example.burgerfreakz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.burgerfreakz.Adapters.CustomerAdapter;
import com.example.burgerfreakz.Classes.Customer;
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

        CustomerAdapter adapter = new CustomerAdapter(CustomerList.this, R.layout.activity_singlecustomer, customers);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Customer customer = customers.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomerList.this);
                builder.setTitle(customer.getFname());
                builder.setMessage(customer.getAddress());
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dbHelper.deleteCustomer(customer.getId());
                        Intent intent2 = new Intent(CustomerList.this,CustomerList.class);
                        startActivity(intent2);


                    }
                });
                builder.setNeutralButton("More Info", new DialogInterface.OnClickListener() {
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
