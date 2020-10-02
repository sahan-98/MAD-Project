package com.example.burgerfreakz;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.burgerfreakz.Database.DBHelper;

public class EmployeeMoreInfo extends AppCompatActivity {
    TextView ename;
    TextView eemail;
    TextView ecity;
    TextView econtactnumber;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_more_info);

        dbHelper = new DBHelper(EmployeeMoreInfo.this);

        ename = (TextView) findViewById(R.id.EPname);
        eemail = (TextView) findViewById(R.id.EPMail);
        ecity = (TextView) findViewById(R.id.EPCity);
        econtactnumber = (TextView) findViewById(R.id.EPContact);

        final String id = getIntent().getStringExtra("Id");
        Employee employee = dbHelper.getEmployee(Integer.parseInt(id));

        ename.setText(employee.getEmpName());
        eemail.setText(employee.getEmpEmail());
        ecity.setText(employee.getEmpCity());
        econtactnumber.setText(employee.getEmpContactNumber());

    }
}