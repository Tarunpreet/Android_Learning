package com.example.singh.punjabi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class Family extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        LinearLayout root=(LinearLayout)findViewById(R.id.root_view);
        final ArrayList<Words> family=new ArrayList<>();


        family.add(new Words("FATHER","PITA JI",R.drawable.f1,R.raw.ik));
        family.add(new Words("MOTHER","MATA JI",R.drawable.f2,R.raw.ik));
        family.add(new Words("SISTER","BEHN JI",R.drawable.f3,R.raw.ik));
        family.add(new Words("BROTHER","VEER JI",R.drawable.f4,R.raw.ik));
        family.add(new Words("GRANDPA","DADA JI",R.drawable.f5,R.raw.ik));
        family.add(new Words("GRANDMA","DADI JI",R.drawable.f6,R.raw.ik));



        WordAdapter itemsAdapter = new WordAdapter(this,family,'f');



        ListView listview=(ListView)findViewById(R.id.list_view);
        listview.setAdapter(itemsAdapter);



    }
}
