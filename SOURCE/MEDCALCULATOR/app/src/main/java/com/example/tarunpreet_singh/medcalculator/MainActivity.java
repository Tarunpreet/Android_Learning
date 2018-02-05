package com.example.tarunpreet_singh.medcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int amount=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText amount1=(EditText)findViewById(R.id.editText);

        Button plus1=(Button)findViewById(R.id.plus);
        final Button percent1=(Button)findViewById(R.id.percent);
        final EditText display=(EditText)findViewById(R.id.editText3);
        final Button clear=(Button)findViewById(R.id.button3);
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amt=amount1.getText().toString();
                amount=amount+Integer.parseInt(amt);

                amt=Integer.toString(amount);
                amount1.setText(amt);
            }
        });
        percent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Oldamount=amount1.getText().toString();
                int oldamount=Integer.parseInt(Oldamount);
                int percentage=(15*oldamount)/100;
                int newamt=oldamount-percentage;
                String amount2=Integer.toString(newamt);
                display.setVisibility(View.VISIBLE);
                display.setText(amount2);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount=0;
                amount1.setText("");
                display.setVisibility(View.INVISIBLE);
            }
        });
    }
}
