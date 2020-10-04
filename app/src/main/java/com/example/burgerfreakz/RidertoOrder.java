package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RidertoOrder extends AppCompatActivity {

    TextView rName,rNo,bNo;
    String name,no,bike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riderto_order);

        rName = findViewById(R.id.oName);
        rNo = findViewById(R.id.oNo);
        bNo = findViewById(R.id.oBno);

        Intent intent = getIntent();
        name = intent.getStringExtra("rName");
        no = intent.getStringExtra("rNo");
        bike = intent.getStringExtra("bNo");

        rName.setText(name);
        rNo.setText(no);
        bNo.setText(bike);
    }
    public void Order(View view){
        Toast.makeText(this, "Rider " + name + " added to the order !!!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, RiderDetails.class);
        startActivity(intent);
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