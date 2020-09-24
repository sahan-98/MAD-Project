package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



    }

    public void Login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void Deals(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}