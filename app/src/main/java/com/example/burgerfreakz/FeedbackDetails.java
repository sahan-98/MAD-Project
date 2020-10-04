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

import com.example.burgerfreakz.Adapters.FeedBackAdapter;
import com.example.burgerfreakz.Adapters.RiderAdapter;
import com.example.burgerfreakz.Classes.FeedbackV;
import com.example.burgerfreakz.Classes.Riders;
import com.example.burgerfreakz.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDetails extends AppCompatActivity {

    ListView listView;

    private List<FeedbackV> feedbackVS;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_details);

        listView = findViewById(R.id.listFeedback);

        final DBHelper dbHelper = new DBHelper(context);
        feedbackVS = new ArrayList<>();

        feedbackVS = dbHelper.getAllFeedback();

        FeedBackAdapter adapter = new FeedBackAdapter(context,R.layout.feedbackrow,feedbackVS);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                final FeedbackV feedbackV = feedbackVS.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Manage the feedback");
                builder.setMessage(feedbackV.getComment() + "\n" + feedbackV.getFmail());
                builder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHelper.deletefeedback(feedbackV.getId());
                        startActivity(new Intent(context,FeedbackDetails.class));
                    }
                });

                builder.show();
            }
        });
    }
    public void Panel(View view){
        Intent intent = new Intent(this, AdminPanel.class);
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
}