package com.example.burgerfreakz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.burgerfreakz.Adapters.EmployeeAdapter;
import com.example.burgerfreakz.Classes.Employee;
import com.example.burgerfreakz.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private List<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        add = findViewById(R.id.Addemp);
        listView = findViewById(R.id.list3);
        final DBHelper dbHelper = new DBHelper(this);
        employees = new ArrayList<>();

        employees = dbHelper.getAllEmployee();

        EmployeeAdapter adapter = new EmployeeAdapter(EmployeeList.this, R.layout.singleemployee,employees);

        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentadd = new Intent(EmployeeList.this, AddEmployee.class);
                startActivity(intentadd);
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Employee employee = employees.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(EmployeeList.this);
                builder.setTitle(employee.getEmpName());
                builder.setMessage(employee.getEmpEmail());
                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent3 = new Intent(EmployeeList.this,UpdateEmployee.class);
                        intent3.putExtra("Id",String.valueOf(employee.getId()));
                        startActivity(intent3);

                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dbHelper.deleteEmployee(employee.getId());
                        Intent intent2 = new Intent(EmployeeList.this, EmployeeList.class);
                        startActivity(intent2);

                    }
                });
                builder.setNeutralButton("MoreInfo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent4 = new Intent(EmployeeList.this,EmployeeMoreInfo.class);
                        intent4.putExtra("Id",String.valueOf(employee.getId()));
                        startActivity(intent4);
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