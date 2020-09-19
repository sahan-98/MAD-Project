package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    public Button btnDeals;
    public Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnDeals = (Button) findViewById(R.id.btnDeals);

        btnDeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(Home.this,MainActivity.class);
                startActivity(intent1);
            }
        });


        button7 = (Button) findViewById(R.id.button3);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7= new Intent(Home.this,Feedback.class);
                startActivity(intent7);
            }
        });

        Button button8 = (Button) findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(Home.this,Customer.class);
                startActivity(intent1);
            }
        });

        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Home.this,MyAccount.class);
                startActivity(intent2);
            }
        });


    }


}