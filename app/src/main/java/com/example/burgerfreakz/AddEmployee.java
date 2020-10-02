package com.example.burgerfreakz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.burgerfreakz.Database.DBHelper;

public class AddEmployee extends AppCompatActivity {
    EditText etName, etEmail, etCity, etContactNumber;
    Button add3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        etName = (EditText) findViewById(R.id.EmpName);
        etEmail = (EditText) findViewById(R.id.EmpEmail);
        etCity = (EditText) findViewById(R.id.EmoCity);
        etContactNumber = (EditText) findViewById(R.id.EmpContact);
        add3 = findViewById(R.id.Addemployee);

        final DBHelper dbHandler = new DBHelper(this);

        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EmployeeName = etName.getText().toString();
                String EmployeeEmail = etEmail.getText().toString();
                String EmployeeCity = etCity.getText().toString();
                String EmployeeContactNumber = etContactNumber.getText().toString();

                Employee employee = new Employee(EmployeeName, EmployeeEmail, EmployeeCity, EmployeeContactNumber);


                Intent intent = new Intent(AddEmployee.this, EmployeeList.class);
                startActivity(intent);

                long val = dbHandler.addEmployee(employee);

                if (val > 0) {
                    Toast.makeText(AddEmployee.this, "Employee added sucessfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddEmployee.this, "Employee added Unsucessfully", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}