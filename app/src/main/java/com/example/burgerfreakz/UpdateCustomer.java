package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.burgerfreakz.Database.DBHelper;


public class UpdateCustomer extends AppCompatActivity {
    EditText fname,lname,email,phone,address,password;
    private DBHelper dbHelper;
    private Button editButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_customer);

        dbHelper = new DBHelper(UpdateCustomer.this);

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.memail);
        phone = (EditText) findViewById(R.id.ephone);
        address = (EditText) findViewById(R.id.eAddress);
        password = (EditText) findViewById(R.id.ePassword);
        editButton = findViewById(R.id.update);

        final String id = getIntent().getStringExtra("Id");
        Customer customer = dbHelper.getCustomer(Integer.parseInt(id));

        fname.setText(customer.getFname());
        lname.setText(customer.getLname());
        email.setText(customer.getEmail());
        phone.setText(customer.getPhone());
        address.setText(customer.getAddress());
        password.setText(customer.getPassword());


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = fname.getText().toString();
                String ln = lname.getText().toString();
                String em = email.getText().toString();
                String ep = phone.getText().toString();
                String ea = address.getText().toString();
                String pw = password.getText().toString();

                /*Customer customer = new Customer(Integer.parseInt(id),fname,lname,email,phone,address,password);
                int state = dbHelper.(customer);
                Intent intentUPD = new Intent(UpdateCustomer.this,CustomerList.class);
                startActivity(intentUPD);*/
            }
        });

    }
}