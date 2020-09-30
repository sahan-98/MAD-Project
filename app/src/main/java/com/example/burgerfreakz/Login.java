package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.burgerfreakz.Database.DBHelper;

import java.util.List;

public class Login extends AppCompatActivity {

    private TextView username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.lUsername);
        password = findViewById(R.id.lPassword);

    }

    public void Login(View view){

        DBHelper dbHelper = new DBHelper(this);

        List usernames = dbHelper.readLoginInfo("user");
        List passwords = dbHelper.readLoginInfo("password");

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(user.equals("Admin") && pass.equals("123")){
            startActivity(new Intent(this,AdminPanel.class));
        }else  Toast.makeText(this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();

        if(usernames.indexOf(user)>=0){
            if(passwords.get(usernames.indexOf(user)).equals(pass)){
                startActivity(new Intent(this,MyAccount.class));
                Toast.makeText(this, "Login successfull !", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
            }
        }

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

    public void SignUp(View view){
        Intent intent = new Intent(this, Accountdetails.class);
        startActivity(intent);
    }
    public void Login(View view){
        Intent intent = new Intent(this, AdminPanel.class);
        startActivity(intent);
    }



}