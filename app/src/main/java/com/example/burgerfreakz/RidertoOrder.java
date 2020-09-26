package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
}