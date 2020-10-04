package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Classes.Customer;
import com.example.burgerfreakz.Database.AppMaster;
import com.example.burgerfreakz.Database.DBHelper;


public class UpdateCustomer extends AppCompatActivity {
    private TextView fname,lname,email,phone,address,header;
    private Context context;
    private DBHelper dbHelper;
    private String username;
    private Button update;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_customer);

        fname = findViewById(R.id.uFname);
        lname = findViewById(R.id.uLname);
        email = findViewById(R.id.uEmail);
        phone = findViewById(R.id.uPhone);
        address = findViewById(R.id.uAddress);
        header = findViewById(R.id.uHeader);
        update = findViewById(R.id.uUpdate);

        context = this;
        dbHelper = new DBHelper(context);

        username = getIntent().getStringExtra("username");
        Customer customer = dbHelper.getsingleCustomer(username);


        header.setText("Hi " + customer.getFname() + " " + customer.getLname());

        id = customer.getId();

        fname.setText(customer.getFname());
        lname.setText(customer.getLname());
        email.setText(customer.getEmail());
        phone.setText(customer.getPhone());
        address.setText(customer.getAddress());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fname = fname.getText().toString();
                String Lname = lname.getText().toString();
                String mail = email.getText().toString();
                String phn = phone.getText().toString();
                String add = address.getText().toString();

                Customer customer1 = new Customer(id,Fname,Lname,mail,phn,add);
                int state = dbHelper.updateCustomer(customer1);
                Intent intent = new Intent(context, MyAccount.class);
                intent.putExtra("username",email.getText().toString());
                startActivity(intent);
                Toast.makeText(context, "Customer Updated Successfully !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Home(View view){
        Intent intent = new Intent(this, MyAccount.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void AboutUs(View view){
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }

    public void Menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}