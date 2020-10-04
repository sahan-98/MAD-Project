package com.example.burgerfreakz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.burgerfreakz.Adapters.PaymentAdapter;
import com.example.burgerfreakz.Classes.PDetails;
import com.example.burgerfreakz.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class PaymentDetails extends AppCompatActivity {

    ListView listView;
    private List<PDetails> pDetails;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        listView = findViewById(R.id.listPayment);
        final DBHelper dbHelper = new DBHelper(context);

        pDetails = new ArrayList<>();
        pDetails = dbHelper.getPaymentDetails();

        PaymentAdapter paymentAdapter = new PaymentAdapter(context,R.layout.activity_payment_row,pDetails);
        listView.setAdapter(paymentAdapter);

    }
    public void Home(View view){
        Intent intent = new Intent(this, AdminPanel.class);
        startActivity(intent);
    }

    public void AboutUs(View view){
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }

    public void Panel(View view){
        Intent intent = new Intent(this, DeliveryPanel.class);
        startActivity(intent);
    }

}