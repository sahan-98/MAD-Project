package com.example.burgerfreakz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.burgerfreakz.Payment;
import com.example.burgerfreakz.R;

public class Continue extends AppCompatActivity {


    RadioGroup radioPayGroup;
    RadioButton radioPayButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        radioPayGroup = findViewById(R.id.payGroup);

    }



    public void PayNow(View view){

        int selectedId = radioPayGroup.getCheckedRadioButtonId();
        radioPayButton = findViewById(selectedId);

        String Pmethod = radioPayButton.getText().toString();

        if(Pmethod.equals("Pay Now")){
            Intent intent = new Intent(Continue.this, Payment.class);
            startActivity(intent);

        }else if(Pmethod.equals("Pay On Delivery")){
            Toast.makeText(Continue.this, "Thank you!! You can Pay on Delivery !!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }







    }




}