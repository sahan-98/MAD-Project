package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class Combo extends AppCompatActivity {

    public Button button1;

    TextView productName1,productName2,productName3, price1,price2,price3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        productName1 = findViewById(R.id.prod1);
        price1 = findViewById(R.id.price1);

        productName2 = findViewById(R.id.prod2);
        price2 = findViewById(R.id.price2);

        productName3 = findViewById(R.id.prod3);
        price3 = findViewById(R.id.price3);


    }
    public void OrderNow1(View view){
        String pName,pPrice;



        pName = productName1.getText().toString();
        pPrice = price1.getText().toString();

        Intent intent = new Intent(Combo.this,Customize.class);
        intent.putExtra("pName", pName);
        intent.putExtra("pPrice", pPrice);
        intent.putExtra("imageView13", R.drawable.com);
        startActivity(intent);

    }

    public void OrderNow2(View view){
        String pName,pPrice;



        pName = productName2.getText().toString();
        pPrice = price2.getText().toString();

        Intent intent1 = new Intent(Combo.this,Customize.class);
        intent1.putExtra("pName", pName);
        intent1.putExtra("pPrice", pPrice);
        intent1.putExtra("imageView13", R.drawable.combo2);
        startActivity(intent1);

    }

    public void OrderNow3(View view){
        String pName,pPrice;



        pName = productName3.getText().toString();
        pPrice = price3.getText().toString();

        Intent intent1 = new Intent(Combo.this,Customize.class);
        intent1.putExtra("pName", pName);
        intent1.putExtra("pPrice", pPrice);
        intent1.putExtra("imageView13", R.drawable.combo3);
        startActivity(intent1);

    }
    public void Burgers(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void hotdogs(View view){
        Intent intent = new Intent(this, Hotdog.class);
        startActivity(intent);
    }
    public void combo(View view){
        Intent intent = new Intent(this, Combo.class);
        startActivity(intent);
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
