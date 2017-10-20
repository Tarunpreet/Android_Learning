package com.example.singh.justjava2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{


    int quantity1=0;
    int price2=5;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView price=(TextView)findViewById(R.id.price_text_view);
        final TextView quantity=(TextView)findViewById(R.id.quantity_text_view);
        Button plus=(Button)findViewById(R.id.plus_button);
        Button minus=(Button)findViewById(R.id.minus_button);
        Button order=(Button)findViewById(R.id.order_button);
        final CheckBox whipped=(CheckBox)findViewById(R.id.whipped_cream);
        final CheckBox chocolate=(CheckBox)findViewById(R.id.Chocolate_cream);
        final EditText name=(EditText)findViewById(R.id.edit_text);
        plus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                quantity1++;
                quantity.setText(""+quantity1);
                quantity.setTextColor(Color.RED);
            }
        });
        minus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(quantity1>0)
                {
                    quantity1--;
                    quantity.setText("" + quantity1);
                }
            }
        });
        order.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v)
            {
                Boolean chocolate2=chocolate.isChecked();
                Boolean whipped2=whipped.isChecked();
                if(chocolate2&&whipped2)
                {
                    price2=25;
                }
                else if(whipped2)
                {
                    price2=10;

                }
                else if(chocolate2)
                {
                    price2=15;
                }
                else
                {
                    price2=5;
                }
                int price1=price2*quantity1;
              //  price.setText(NumberFormat.getCurrencyInstance().format(price1));
                String name1=name.getText().toString();
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"JUST JAVA APP FOR "+name1);
                String description1="Price for "+quantity1 +" Coffee ";

                if(chocolate2&&whipped2)
                {
                    description1=description1+"With Topping Chocolate and Whipped cream is ";
                }
                else if(chocolate2)
                {
                    description1=description1+"With Topping Chocolate is ";
                }
                else if (whipped2)
                {
                    description1=description1+"With Topping Whipped cream is ";
                }
               description1=description1+price1;
                Log.d("Message",description1);
                intent.putExtra(Intent.EXTRA_TEXT,description1);
                if(intent.resolveActivity(getPackageManager())!=null)
                {
                   startActivity(intent);
                }
            }
        });


    }
}
