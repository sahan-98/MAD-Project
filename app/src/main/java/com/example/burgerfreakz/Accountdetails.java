package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Database.DBHelper;

public class Accountdetails extends AppCompatActivity {

    TextView fname,lname,email,phone,address,password,conPassword;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountdetails);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.memail);
        phone = findViewById(R.id.ephone);
        address = findViewById(R.id.eAddress);
        password = findViewById(R.id.ePassword);
        conPassword = findViewById(R.id.ecPassword);

        context = this;

    }


    public void signup(View view){
        DBHelper dbHelper = new DBHelper(context);

         String firstname = fname.getText().toString();
         String lastname = lname.getText().toString();
         String mail = email.getText().toString();
         String pHONE = phone.getText().toString();
         String Address = address.getText().toString();
         String Password = password.getText().toString();



        if(password.getText().toString().equals(conPassword.getText().toString()))
        {

           long val = dbHelper.addCustomerDetails(firstname,lastname,mail,pHONE,Address);
            long val2 = dbHelper.addLoginInfo(mail,Password);

            if(val>0){
                Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
            password.setText("");
            conPassword.setText("");
        }



    }





}