package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.burgerfreakz.Classes.Customer;
import com.example.burgerfreakz.Database.DBHelper;

public class MoreInfo extends AppCompatActivity {
    private DBHelper dbHelper;
    private TextView  fname,lname,email,phone,add,header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        dbHelper = new DBHelper(MoreInfo.this);

        fname = (TextView) findViewById(R.id.firstn);
        lname = (TextView) findViewById(R.id.lastn);
        email = (TextView) findViewById(R.id.eemail);
        phone = (TextView) findViewById(R.id.pnumber);
        add = (TextView) findViewById(R.id.add);
        header = findViewById(R.id.mHeader);

        final String id = getIntent().getStringExtra("Id");
        Customer customer = dbHelper.getCustomer(Integer.parseInt(id));

        header.setText(customer.getFname() + " " + customer.getLname() + " !!");

        fname.setText(customer.getFname());
        lname.setText(customer.getLname());
        email.setText(customer.getEmail());
        phone.setText(customer.getPhone());
        add.setText(customer.getAddress());
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