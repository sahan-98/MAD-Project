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


    String pName, pPrice, pSize,username;
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

        username = getIntent().getStringExtra("username");
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
        Total = Tot(price,quant);
        service = Service(Total,discount);

        description.setText(pName + "\nRs." + pPrice + "\n"+ pSize);
        subTotal.setText("Rs. " + String.valueOf(price));
        discTot.setText("Rs. " + String.valueOf(price));
        scharge.setText("Rs." + String.valueOf(service));
        netTotal.setText("Rs. " + String.valueOf(price + service));

    }

    public float Service(float Total , float discount){
        return (Total - discount) * 5/100;
    }

    public float Tot(float price , float quant){
        return price * quant;
    }

    public float discountedTotal(float total,float discount){
        return total - discount;
    }

    public float netTotal(float total,float service,float discount){
        return total + service - discount;
    }

    public void Enter(View view){
        if(promo.getText().toString().equals("BFZ")){
            discount = Float.valueOf(100);
            service = Service(Total,discount);
            disc.setText("Rs. "+ String.valueOf(discount));
            discTot.setText("Rs. "+ String.valueOf(discountedTotal(Total,discount)));
            scharge.setText("Rs." + String.valueOf(service));
            netTotal.setText("Rs. " + String.valueOf(netTotal(Total,service,discount)));
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
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void Increase(View view){
                quant = quant + 1;

                Total = Tot(price,quant);
                service = Service(Total,discount);
                subTotal.setText("Rs. " + String.valueOf(Total));
                discTot.setText("Rs. "+ String.valueOf(discountedTotal(Total,discount)));
                netTotal.setText("Rs. " + String.valueOf(netTotal(Total,service,discount)));
                scharge.setText("Rs." + String.valueOf(service));
                quantity.setText(String.valueOf(quant));
    }

    public void Decrease(View view){
                if (quant > 1) {
                    quant = quant - 1;
                    Total = Tot(price,quant);
                    service = Service(Total,discount);
                }
                subTotal.setText("Rs. " + String.valueOf(Total));
                discTot.setText("Rs. "+ String.valueOf(discountedTotal(Total,discount)));
                netTotal.setText("Rs. " + String.valueOf(netTotal(Total,service,discount)));
                scharge.setText("Rs." + String.valueOf(service));
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
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void Home(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void AboutUs(View view){
        Intent intent = new Intent(this, Feedback.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void Menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

}