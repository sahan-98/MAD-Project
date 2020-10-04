package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.burgerfreakz.Classes.Customer;
import com.example.burgerfreakz.Database.DBHelper;

public class MyAccount extends AppCompatActivity {
    private Context context;
    private DBHelper dbHelper;
    String username;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        header = findViewById(R.id.mHeader);

        context = this;
        dbHelper = new DBHelper(context);

        username = getIntent().getStringExtra("username");
        Customer customer = dbHelper.getsingleCustomer(username);

        header.setText("Hi " + customer.getFname() + " " + customer.getLname()+" !!!");

    }

    public void Update (View view){
        Intent intent = new Intent(this, UpdateCustomer.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void ChangePassword(View view){
        Intent intent = new Intent(this, changePassword.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void Logout  (View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void Home(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void AboutUs(View view){
        Intent intent = new Intent(this, Feedback.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void Menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

}