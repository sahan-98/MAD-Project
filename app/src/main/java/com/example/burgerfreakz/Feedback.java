package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.burgerfreakz.Classes.FeedbackV;
import com.example.burgerfreakz.Database.DBHelper;

public class Feedback extends AppCompatActivity {
    EditText fcomment,femail;
    Button FeedADD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        fcomment = findViewById(R.id.FeedComment);
        femail = findViewById(R.id.email);
        FeedADD = findViewById(R.id.feedSubmit);

        final DBHelper dbHelper = new DBHelper(this);

        FeedADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FeedComment = fcomment.getText().toString();
                String FeedMail = femail.getText().toString();

                FeedbackV feedbackV = new FeedbackV(FeedComment,FeedMail);

                Intent intent= new Intent(Feedback.this,Home.class);
                startActivity(intent);


                long val = dbHelper.addfeedback(feedbackV);

                if(val > 0){
                    Toast.makeText(Feedback.this,"Your FeedBack added sucessfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Feedback.this,"Your FeedBack added Unsucessfully",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}