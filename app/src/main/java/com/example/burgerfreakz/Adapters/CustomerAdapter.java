package com.example.burgerfreakz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.burgerfreakz.Customer;
import com.example.burgerfreakz.R;

import java.util.List;

public class CustomerAdapter extends ArrayAdapter<Customer> {

    private Context context;
    private int resource;
    List<Customer> customers;

    public CustomerAdapter(Context context, int resource, List<Customer> customers) {
        super(context, resource,customers);
        this.context = context;
        this.resource = resource;
        this.customers = customers;
    }

    @NonNull
    @Override
    public View getView(int position , @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

         TextView Topic = row.findViewById(R.id.topic);
         Customer customer = customers.get(position);
         Topic.setText(customer.getFname());

         return row;
    }
}
