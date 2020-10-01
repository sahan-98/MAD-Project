package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Classes.LoginD;
import com.example.burgerfreakz.Database.DBHelper;

public class changePassword extends AppCompatActivity {

    public String username;
    private Context context;
    private DBHelper dbHelper;
    private Button update;
    private int id;
    private TextView pass,conpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        pass = findViewById(R.id.cPassword);
        conpass = findViewById(R.id.cConPassword);
        update = findViewById(R.id.chPassword);

        context = this;
        dbHelper = new DBHelper(context);

        username = getIntent().getStringExtra("username");
        LoginD loginD = dbHelper.getPassword(username);

        id = loginD.getId();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pass.getText().toString().equals(conpass.getText().toString())){
                    String password = pass.getText().toString();

                    LoginD login = new LoginD(id,username,password);
                    int state = dbHelper.updatePassword(login);
                    Intent intent = new Intent(context, Login.class);
                    startActivity(intent);
                    Toast.makeText(context, "Password Changed Successfully !!", Toast.LENGTH_SHORT).show();
                }else {
                    pass.setText("");
                    conpass.setText("");
                    Toast.makeText(context, "Password Mismatch !!", Toast.LENGTH_SHORT).show();}


            }
        });


    }
}