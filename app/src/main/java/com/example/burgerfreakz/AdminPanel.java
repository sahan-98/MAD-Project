package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class AdminPanel extends AppCompatActivity {

    public Button button3 ;
    public Button button4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        button3 = (Button) findViewById(R.id.button13);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(AdminPanel.this,AddProduct.class);
                startActivity(intent1);
            }
        });

        button4 = (Button) findViewById(R.id.button14);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(AdminPanel.this,RidertoOrder.class);
                startActivity(intent1);
            }
        });
    }


}