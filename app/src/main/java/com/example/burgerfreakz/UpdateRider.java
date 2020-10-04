package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Database.DBHelper;
import com.example.burgerfreakz.Classes.Riders;

public class UpdateRider extends AppCompatActivity {

    TextView name,no,phone,bike;
    private Context context;
    private DBHelper dbHelper;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_rider);

        context = this;
        dbHelper = new DBHelper(context);


        name = findViewById(R.id.Urname);
        no  = findViewById(R.id.Urno);
        phone = findViewById(R.id.Urphone);
        bike = findViewById(R.id.Ubno);
        update = findViewById(R.id.updateRider);

        final String id = getIntent().getStringExtra("id");
        Riders riders = dbHelper.getSingleRider(Integer.parseInt(id));

        name.setText(riders.getName());
        no.setText(riders.getRiderNo());
        phone.setText(riders.getPhone());
        bike.setText(riders.getBikeNo());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rname = name.getText().toString();
                String rno = no.getText().toString();
                String rphone = phone.getText().toString();
                String rbike = bike.getText().toString();

                Riders riders = new Riders(Integer.parseInt(id),rname,rno,rphone,rbike);
                int state = dbHelper.updateRider(riders);
                startActivity(new Intent(context,RiderDetails.class));
                Toast.makeText(UpdateRider.this, "Rider Updated Successfully !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Panel(View view){
        Intent intent = new Intent(this, DeliveryPanel.class);
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



}