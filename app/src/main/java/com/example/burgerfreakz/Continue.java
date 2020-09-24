package com.example.burgerfreakz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Database.DBHelper;
import com.example.burgerfreakz.Payment;
import com.example.burgerfreakz.R;

public class Continue extends AppCompatActivity {


    RadioGroup radioPayGroup;
    RadioButton radioPayButton;
    String Pmethod,product,total,sCharg,netTotal;
    TextView fname,lname,address,phone,landmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        fname = findViewById(R.id.pFname);
        lname = findViewById(R.id.pLname);
        address = findViewById(R.id.pAddress);
        phone = findViewById(R.id.pPhone);
        landmarks = findViewById(R.id.pLandmarks);
        radioPayGroup = findViewById(R.id.payGroup);


    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        product = intent.getStringExtra("product");
        total = intent.getStringExtra("subTotal");
        sCharg = intent.getStringExtra("sCharge");
        netTotal = intent.getStringExtra("netTotal");


    }

    public void PayNow(View view){

        int selectedId = radioPayGroup.getCheckedRadioButtonId();
        radioPayButton = findViewById(selectedId);

         Pmethod = radioPayButton.getText().toString();

        if(Pmethod.equals("Pay Now")){
            Intent intent = new Intent(Continue.this, Payment.class);
            startActivity(intent);

        }else if(Pmethod.equals("Pay On Delivery")){
            Toast.makeText(Continue.this, "Thank you!! You can Pay on Delivery !!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }

        DBHelper dbHelper = new DBHelper(this);

        long val = dbHelper.addPaymentDetails(fname.getText().toString(),lname.getText().toString(),phone.getText().toString(),address.getText().toString(),
                landmarks.getText().toString(),product,Pmethod,total,sCharg,netTotal);

        if(val > 0){
            Toast.makeText(this, "Data inserted successfully ", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Data not inserted ", Toast.LENGTH_SHORT).show();
        }


    }

    public void Home(View view){
        Intent intent = new Intent(this, Home.class);
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