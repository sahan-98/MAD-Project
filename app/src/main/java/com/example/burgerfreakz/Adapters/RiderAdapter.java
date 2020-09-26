package com.example.burgerfreakz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.burgerfreakz.Classes.Riders;
import com.example.burgerfreakz.R;

import java.util.List;

public class RiderAdapter extends ArrayAdapter<Riders> {

    private Context context;
    private int resource;
    List<Riders> riders;

    public RiderAdapter(Context context,int resource, List<Riders> riders){
        super(context,resource,riders);
        this.context = context;
        this.resource = resource;
        this.riders = riders;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView rname = row.findViewById(R.id.ridName);
        TextView ridno = row.findViewById(R.id.ridNo);
        TextView phone = row.findViewById(R.id.ridPhone);
        TextView bike = row.findViewById(R.id.ridBike);

        Riders rider = riders.get(position);
        rname.setText(rider.getName());
        ridno.setText(rider.getRiderNo());
        phone.setText(rider.getPhone());
        bike.setText(rider.getBikeNo());

        return row;

    }
}
