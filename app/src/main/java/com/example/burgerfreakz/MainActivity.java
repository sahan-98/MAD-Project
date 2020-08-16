package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public Button button1;
    public ImageButton button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MainActivity.this,Customize.class);
                startActivity(intent1);
            }
        });

        button2 = (ImageButton) findViewById(R.id.imageButton2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent2 = new Intent(MainActivity.this,AdminPanel.class);
              startActivity(intent2);
            }
        });
    }
}
