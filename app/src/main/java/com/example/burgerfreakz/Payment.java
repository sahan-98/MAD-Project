package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Feedback;
import com.example.burgerfreakz.Home;
import com.example.burgerfreakz.Invoice;
import com.example.burgerfreakz.MainActivity;
import com.example.burgerfreakz.R;

public class Payment extends AppCompatActivity {

    private String name,address,product,quantity,unit,total,service,net,discount;
    private TextView pMethod,holder,expire,cvv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        pMethod = findViewById(R.id.pCard);
        holder = findViewById(R.id.pHolder);
        expire = findViewById(R.id.pDate);
        cvv = findViewById(R.id.pCvv);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        product = intent.getStringExtra("product");
        quantity = intent.getStringExtra("quant");
        unit = intent.getStringExtra("unit");
        total = intent.getStringExtra("total");
        discount = intent.getStringExtra("discount");
        service = intent.getStringExtra("service");
        net = intent.getStringExtra("net");
    }

    public void Pay(View view){

        if(TextUtils.isEmpty(pMethod.getText()) || TextUtils.isEmpty(holder.getText()) || TextUtils.isEmpty(expire.getText())
                || TextUtils.isEmpty(cvv.getText()) ){
            Toast.makeText(this, "Fields Cannot be Empty!!!", Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(this, "Thank you for your payment ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Invoice.class);
            intent.putExtra("name", name);
            intent.putExtra("address", address);
            intent.putExtra("method", pMethod.getText().toString());
            intent.putExtra("product", product);
            intent.putExtra("quant", quantity);
            intent.putExtra("unit", unit);
            intent.putExtra("total", total);
            intent.putExtra("discount", discount);
            intent.putExtra("service", service);
            intent.putExtra("net", net);
            startActivity(intent);
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