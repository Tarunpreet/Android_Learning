package com.example.singh.punjabi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView number=(TextView)findViewById(R.id.numbers);
        TextView fam=(TextView)findViewById(R.id.family);
        TextView Alphabets=(TextView)findViewById(R.id.alphabets);
        TextView phrase=(TextView)findViewById(R.id.phrases);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numi=new Intent(MainActivity.this,Numbers.class);
                startActivity(numi);
            }
        });
        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyi=new Intent(MainActivity.this,Family.class);
                startActivity(familyi);
            }
        });
        Alphabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsi=new Intent(MainActivity.this,Alphabets.class);
                startActivity(colorsi);
            }
        });
      phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasei=new Intent(MainActivity.this,Phrases.class);
                startActivity(phrasei);
            }
        });
    }

}
