package com.example.burgerfreakz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Classes.Customer;
import com.example.burgerfreakz.Database.DBHelper;

public class Continue extends AppCompatActivity {


    RadioGroup radioPayGroup;
    RadioButton radioPayButton;
    private String Pmethod,product,total,discount,sCharg,netTotal,quantity,unit,username;
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

        username = getIntent().getStringExtra("username");

        DBHelper dbHelper = new DBHelper(this);

        if(!"null".equals(username)){
            Customer customer = dbHelper.getsingleCustomer(username);
            address.setText(customer.getAddress());
            fname.setText(customer.getFname());
            lname.setText(customer.getLname());
            phone.setText(customer.getPhone());
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        product = intent.getStringExtra("product");
        total = intent.getStringExtra("subTotal");
        discount = intent.getStringExtra("discount");
        sCharg = intent.getStringExtra("sCharge");
        netTotal = intent.getStringExtra("netTotal");
        quantity = intent.getStringExtra("quantity");
        unit = intent.getStringExtra("unitPrice");

    }

    public void PayNow(View view){

        int selectedId = radioPayGroup.getCheckedRadioButtonId();
        radioPayButton = findViewById(selectedId);

         Pmethod = radioPayButton.getText().toString();

         if(TextUtils.isEmpty(fname.getText()) || TextUtils.isEmpty(lname.getText()) || TextUtils.isEmpty(address.getText())
         || TextUtils.isEmpty(phone.getText()) ){
             Toast.makeText(this, "Fields Cannot be Empty!!!", Toast.LENGTH_SHORT).show();
         }else {

             if (Pmethod.equals("Pay Now")) {
                 Intent intent = new Intent(Continue.this, Payment.class);
                 intent.putExtra("name", fname.getText().toString() + " " + lname.getText().toString());
                 intent.putExtra("address", address.getText().toString());
                 intent.putExtra("product", product);
                 intent.putExtra("quant", quantity);
                 intent.putExtra("unit", unit);
                 intent.putExtra("total", total);
                 intent.putExtra("discount", discount);
                 intent.putExtra("service", sCharg);
                 intent.putExtra("net", netTotal);
                 intent.putExtra("username",username);
                 startActivity(intent);

             } else if (Pmethod.equals("Pay On Delivery")) {
                 Toast.makeText(Continue.this, "Thank you!! You can Pay on Delivery !!", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(this, Invoice.class);
                 intent.putExtra("name", fname.getText().toString() + " " + lname.getText().toString());
                 intent.putExtra("address", address.getText().toString());
                 intent.putExtra("method", Pmethod);
                 intent.putExtra("product", product);
                 intent.putExtra("quant", quantity);
                 intent.putExtra("unit", unit);
                 intent.putExtra("total", total);
                 intent.putExtra("discount", discount);
                 intent.putExtra("service", sCharg);
                 intent.putExtra("net", netTotal);
                 intent.putExtra("username",username);
                 startActivity(intent);
             }

             DBHelper dbHelper = new DBHelper(this);

             long val = dbHelper.addPaymentDetails(fname.getText().toString(), lname.getText().toString(), phone.getText().toString(), address.getText().toString(),
                     landmarks.getText().toString(), product, Pmethod, total, sCharg, netTotal);

             if (val > 0) {
                 Toast.makeText(this, "Enter your payment details !!", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(this, "Data not inserted ", Toast.LENGTH_SHORT).show();
             }

         }
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