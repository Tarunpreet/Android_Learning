package com.example.singh.justjava;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    int quantity1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView price=(TextView)findViewById(R.id.price_text_view);
        final TextView quantity=(TextView)findViewById(R.id.quantity_text_view);
        Button plus=(Button)findViewById(R.id.plus_button);
        Button minus=(Button)findViewById(R.id.minus_button);
        Button order=(Button)findViewById(R.id.order_button);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity1++;
                quantity.setText(""+quantity1);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity1>0) {
                    quantity1--;
                    quantity.setText("" + quantity1);
                }
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                int price1=5*quantity1;
                price.setText(NumberFormat.getCurrencyInstance().format(price1));
            }
        });

    }
}
