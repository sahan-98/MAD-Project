package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DeliveryPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_panel);
    }

    public void Rider(View view){
        Intent intent = new Intent(this, RidertoSystem.class);
        startActivity(intent);
    }

    public void Order(View view){
        Intent intent = new Intent(this, PaymentDetails.class);
        startActivity(intent);
    }


}