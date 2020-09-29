package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class shoppingcart extends AppCompatActivity {


    String pName, pPrice, pSize;
    TextView description, quantity, subTotal, netTotal, scharge,promo,disc,discTot;
    Float price, service, Total,discount = Float.valueOf(0);
    Integer quant = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);

        description = findViewById(R.id.txtCart);
        subTotal = findViewById(R.id.txtSubtotal);
        netTotal = findViewById(R.id.txtNettotal);
        scharge = findViewById(R.id.txtScharge);
        quantity = findViewById(R.id.textQuantity);
        promo = findViewById(R.id.txtPromo);
        disc = findViewById(R.id.txtDisc);
        discTot = findViewById(R.id.disctot);
        quantity.setText(String.valueOf(quant));

    }

    @Override
    protected void onResume() {
        super.onResume();

        disc.setText("Rs. 0.0");

        Intent dintent = getIntent();
        pName = dintent.getStringExtra("pName");
        pPrice = dintent.getStringExtra("pPrice");
        pSize = dintent.getStringExtra("pSize");

        price = Float.parseFloat(pPrice);
        service = price * 5 / 100;

        description.setText(pName + "\nRs." + pPrice + "\n"+ pSize);
        subTotal.setText("Rs. " + String.valueOf(price));
        scharge.setText("Rs." + String.valueOf(service));
        netTotal.setText("Rs. " + String.valueOf(price + service));

    }
    public void Enter(View view){
        if(promo.getText().toString().equals("BFZ")){
            discount = Float.valueOf(100);
            disc.setText("Rs. "+ String.valueOf(discount));
            discTot.setText("Rs. "+ String.valueOf(Total - discount));
            netTotal.setText("Rs. " + String.valueOf(Total + service - discount));
        }else {
            Toast.makeText(this, "Invalid Promo Code", Toast.LENGTH_SHORT).show();
        }
    }
    public void Continue(View view){
        Intent intent = new Intent(shoppingcart.this, Continue.class);
        intent.putExtra("product",pName);
        intent.putExtra("subTotal",subTotal.getText().toString());
        intent.putExtra("discount",disc.getText().toString());
        intent.putExtra("sCharge",scharge.getText().toString());
        intent.putExtra("netTotal",netTotal.getText().toString());
        intent.putExtra("quantity",quantity.getText().toString());
        intent.putExtra("unitPrice",pPrice);
        startActivity(intent);
    }

    public void Increase(View view){
                quant = quant + 1;
                Total = price * quant;
                subTotal.setText("Rs. " + String.valueOf(Total));
                discTot.setText("Rs. "+ String.valueOf(Total - discount));
                netTotal.setText("Rs. " + String.valueOf(Total + service - discount));
                quantity.setText(String.valueOf(quant));
    }

    public void Decrease(View view){
                if (quant > 1) {
                    quant = quant - 1;

                    Total = price * quant;
                }
                subTotal.setText("Rs. " + String.valueOf(Total));
                discTot.setText("Rs. "+ String.valueOf(Total - discount));
                netTotal.setText("Rs. " + String.valueOf(Total + service - discount));
                quantity.setText(String.valueOf(quant));
    }

    public void Delete(View view){
                quant = 1;
                price = Float.valueOf(0);
                service = Float.valueOf(0);
                description.setText("");
                promo.setText("");
                subTotal.setText("Rs. 0.00");
                scharge.setText("Rs. 0.00");
                disc.setText("Rs. 0.00");
                discTot.setText("Rs. 0.00");
                netTotal.setText("Rs. 0.00");
                quantity.setText("1");

    }

    public void Shopping(View view){
        Intent intent = new Intent(shoppingcart.this, MainActivity.class);
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

    public void Menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}