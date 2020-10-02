package com.example.burgerfreakz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.burgerfreakz.Database.DBHelper;

public class UpdateEmployee extends AppCompatActivity {
    TextView etName, etEmail, etCity, etContactNumber;
    private DBHelper dbHelper;
    private Button editButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);

        dbHelper = new DBHelper(UpdateEmployee.this);

        etName = (EditText) findViewById(R.id.EmpName);
        etEmail = (EditText) findViewById(R.id.EmpEmail);
        etCity = (EditText) findViewById(R.id.EmoCity);
        etContactNumber = (EditText) findViewById(R.id.EmpContact);
        editButton = findViewById(R.id.empUp);

        final String id = getIntent().getStringExtra("Id");
        final Employee employee = dbHelper.getEmployee(Integer.parseInt(id));

        etName.setText(employee.getEmpName());
        etEmail.setText(employee.getEmpEmail());
        etCity.setText(employee.getEmpCity());
        etContactNumber.setText(employee.getEmpContactNumber());


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etname = etName.getText().toString();
                String etcode = etEmail.getText().toString();
                String etcity = etCity.getText().toString();
                String etcontactnumber = etContactNumber.getText().toString();

                Employee employee = new Employee(Integer.parseInt(id),etname,etcode,etcity,etcontactnumber);
                int state = dbHelper.updateEmployee(employee);
                Intent intentUPD = new Intent(UpdateEmployee.this, EmployeeList.class);
                startActivity(intentUPD);
            }
        });

    }

}