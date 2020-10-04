package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Database.DBHelper;

import java.util.List;

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

        if(TextUtils.isEmpty(fname.getText()) || TextUtils.isEmpty(lname.getText()) || TextUtils.isEmpty(email.getText())
                || TextUtils.isEmpty(phone.getText()) || TextUtils.isEmpty(address.getText()) || TextUtils.isEmpty(password.getText())){
            Toast.makeText(this, "Fields Cannot be Empty!!!", Toast.LENGTH_SHORT).show();
        }else {

            if (password.getText().toString().equals(conPassword.getText().toString())) {

                List usernames = dbHelper.readLoginInfo("user");

                if (usernames.contains(mail)) {
                    Toast.makeText(context, "Email Already Exist!!", Toast.LENGTH_SHORT).show();
                } else {

                    long val = dbHelper.addCustomerDetails(firstname, lastname, mail, pHONE, Address);
                    long val2 = dbHelper.addLoginInfo(mail, Password);


                    if (val > 0) {
                        Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, Login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(context, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }

            } else {
                Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                password.setText("");
                conPassword.setText("");
            }
        }
}

    public void Home(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void AboutUs(View view){
        Intent intent = new Intent(this, Feedback.class);
        intent.putExtra("username","null");
        startActivity(intent);
    }

    public void Menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username","null");
        startActivity(intent);
    }
    }





