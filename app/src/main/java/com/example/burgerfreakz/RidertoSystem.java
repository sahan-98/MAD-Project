package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Database.DBHelper;

import java.util.List;

public class RidertoSystem extends AppCompatActivity {

    EditText rname,rno,phone,bno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riderto_system);

        rname = findViewById(R.id.rname);
        rno = findViewById(R.id.rno);
        phone = findViewById(R.id.rphone);
        bno = findViewById(R.id.bno);

    }

    public void addRider(View view){
        DBHelper dbHelper = new DBHelper(this);

        long val = dbHelper.addRiderDetails(rname.getText().toString(),rno.getText().toString(),phone.getText().toString(),bno.getText().toString());

        if(val > 0){
            Toast.makeText(this, "Rider inserted successfully ", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Data not inserted ", Toast.LENGTH_SHORT).show();
        }
    }

    public void viewRiders(View view){
        DBHelper dbHelper = new DBHelper(this);

        List Rnos = dbHelper.RiderInfo();

        Toast.makeText(this, Rnos.toString() , Toast.LENGTH_SHORT).show();

    }


}