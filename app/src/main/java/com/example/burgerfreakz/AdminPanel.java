package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class AdminPanel extends AppCompatActivity {

    public Button button3 ;
    public Button button4 ;
    public Button button5 ;
    public Button button6 ,employee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        button3 = (Button) findViewById(R.id.button13);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AdminPanel.this,ProductList.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.button14);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(AdminPanel.this,DeliveryPanel.class);
                startActivity(intent1);
            }
        });

        button5 = (Button) findViewById(R.id.customerMang);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(AdminPanel.this,CustomerList.class);
                startActivity(intent1);
            }
        });

        button6 = (Button) findViewById(R.id.feedback1);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(AdminPanel.this,FeedbackDetails.class);
                startActivity(intent1);
            }
        });

        employee = findViewById(R.id.EmployeeM);

        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(AdminPanel.this,EmployeeList.class);
                startActivity(intent1);
            }
        });



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
        intent.putExtra("username","null");
        startActivity(intent);
    }

    public void Logout  (View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}