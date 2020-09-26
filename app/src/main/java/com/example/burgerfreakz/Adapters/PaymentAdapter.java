package com.example.burgerfreakz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.burgerfreakz.Classes.PDetails;
import com.example.burgerfreakz.R;

import java.util.List;

public class PaymentAdapter extends ArrayAdapter<PDetails> {

    private Context context;
    private int resource;
    List<PDetails> pDetailsList;


    public PaymentAdapter(Context context, int resource, List<PDetails> pDetails) {
        super(context, resource,pDetails);
        this.context = context;
        this.resource = resource;
        this.pDetailsList = pDetails;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView fname = row.findViewById(R.id.pFname);
        TextView lname = row.findViewById(R.id.pLname);
        TextView phone = row.findViewById(R.id.pPhone);
        TextView address = row.findViewById(R.id.pAddress);
        TextView land = row.findViewById(R.id.pLandmarks);
        TextView prod = row.findViewById(R.id.pProduct);
        TextView method = row.findViewById(R.id.pMethod);
        TextView sub = row.findViewById(R.id.pSub);
        TextView schg = row.findViewById(R.id.pSchrg);
        TextView net = row.findViewById(R.id.pNettot);


        if(position == 0){
            PDetails details = pDetailsList.get(0);
            fname.setText("First Name\n\n"+details.getFname());
            lname.setText("Last Name\n\n"+details.getLname());
            phone.setText("Phone No\n\n"+details.getPhone());
            address.setText("Address\n\n"+details.getAddress());
            land.setText("Landmarks\n\n"+details.getLandmarks());
            prod.setText("Product\n\n"+details.getProduct());
            method.setText("Method\n\n"+details.getMethod());
            sub.setText("Sub Total\n\n"+details.getSub());
            schg.setText("Service charge\n\n"+details.getSchrg());
            net.setText("Net Total\n\n"+details.getNet());
        }else{

            PDetails details = pDetailsList.get(position);
            fname.setText(details.getFname());
            lname.setText(details.getLname());
            phone.setText(details.getPhone());
            address.setText(details.getAddress());
            land.setText(details.getLandmarks());
            prod.setText(details.getProduct());
            method.setText(details.getMethod());
            sub.setText(details.getSub());
            schg.setText(details.getSchrg());
            net.setText(details.getNet());

        }



        return row;

    }
}
