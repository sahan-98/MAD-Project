package com.example.burgerfreakz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.burgerfreakz.Employee;
import com.example.burgerfreakz.R;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context context;
    private int resource;
    List<Employee> employees;

    public EmployeeAdapter(Context context, int resource, List<Employee> employees){
        super(context,resource,employees);
        this.context = context;
        this.resource = resource;
        this.employees = employees;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView title = row.findViewById(R.id.Titlee);

        Employee employee = employees.get(position);
        title.setText(employee.getEmpName());

        return row;
    }
}
