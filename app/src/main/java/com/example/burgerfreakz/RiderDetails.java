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

import com.example.burgerfreakz.Database.DBHelper;
import com.example.burgerfreakz.Adapters.RiderAdapter;
import com.example.burgerfreakz.Classes.Riders;

import java.util.ArrayList;
import java.util.List;

public class RiderDetails extends AppCompatActivity {

    ListView listView;

    private List<Riders> riders;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_details);

        listView = findViewById(R.id.listRider);

        final DBHelper dbHelper = new DBHelper(context);
        riders = new ArrayList<>();

        riders = dbHelper.getAllRiders();

        RiderAdapter adapter = new RiderAdapter(context,R.layout.activity_rider_row,riders);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                final Riders rider = riders.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Edit Riders Details");
                builder.setMessage(rider.getRiderNo() + "\n" + rider.getName());
                builder.setPositiveButton("ASSIGN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context, RidertoOrder.class);
                        intent.putExtra("rNo",rider.getRiderNo());
                        intent.putExtra("rName",rider.getName());
                        intent.putExtra("bNo",rider.getBikeNo());
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            dbHelper.deleteRider(rider.getID());
                            startActivity(new Intent(context,RiderDetails.class));
                    }
                });
                builder.setNeutralButton("UPDATE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context,UpdateRider.class);
                        intent.putExtra("id",String.valueOf(rider.getID()));
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });





    }

}