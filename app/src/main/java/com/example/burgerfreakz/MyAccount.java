package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        Button button1 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MyAccount.this,Accountdetails.class);
                startActivity(intent1);
            }
        });

        Button button2 = (Button) findViewById(R.id.button5);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(MyAccount.this,Order.class);
                startActivity(intent2);
            }
        });

        Button button3 = (Button) findViewById(R.id.button8);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MyAccount.this,Address.class);
                startActivity(intent1);
            }
        });

        Button button4 = (Button) findViewById(R.id.button11);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MyAccount.this,Password.class);
                startActivity(intent1);
            }
        });

        Button button5 = (Button) findViewById(R.id.button9);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MyAccount.this,Phone.class);
                startActivity(intent1);
            }
        });

        Button button6 = (Button) findViewById(R.id.button10);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MyAccount.this,Email.class);
                startActivity(intent1);
            }
        });
    }
}