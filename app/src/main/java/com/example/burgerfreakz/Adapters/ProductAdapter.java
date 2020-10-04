package com.example.burgerfreakz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.burgerfreakz.Classes.Product;
import com.example.burgerfreakz.R;

import java.util.List;


public class ProductAdapter extends ArrayAdapter<Product> {

    private Context context;
    private int resource;
    List<Product> products;

    public ProductAdapter(Context context, int resource, List<Product> products){
        super(context,resource,products);
        this.context = context;
        this.resource = resource;
        this.products = products;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView title = row.findViewById(R.id.Titleeee);

        Product product = products.get(position);
        title.setText(product.getProName());

        return row;
    }
}
