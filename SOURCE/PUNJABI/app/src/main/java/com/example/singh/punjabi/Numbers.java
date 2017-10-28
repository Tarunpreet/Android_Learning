package com.example.singh.punjabi;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        LinearLayout root=(LinearLayout)findViewById(R.id.root_view);
        final ArrayList<Words> numbers=new ArrayList<>();


        numbers.add(new Words("ONE","IK",R.drawable.n1,R.raw.ik));
        numbers.add(new Words("TWO","DO",R.drawable.n2,R.raw.doo));
        numbers.add(new Words("THREE","TINN",R.drawable.n3,R.raw.tin));
        numbers.add(new Words("FOUR","CHAAR",R.drawable.n4,R.raw.chaar));
        numbers.add(new Words("FIVE","PUNJ",R.drawable.n5,R.raw.punj));
        numbers.add(new Words("SIX","CHE",R.drawable.n6,R.raw.che));
        numbers.add(new Words("SEVEN","SAT",R.drawable.n7,R.raw.sat));
        numbers.add(new Words("EIGHT","ATH",R.drawable.n8,R.raw.ath));
        numbers.add(new Words("NINE","NAU",R.drawable.n9,R.raw.nau));
        numbers.add(new Words("TEN","DAS",R.drawable.n10,R.raw.das));

        //listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "YOU CLICKED ON "+numbers_english.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });



        //LIST ITEM ARE PLACES WHICH WE SEE AND ARE ADDED TO LISTVIEW
        //WHEN WE USE SCROLL THEM AWAY THEY ARE STORED IN SCRAPVIEW
        //WHEN WE NEED AN EXTRA ITEM TO BE DISPLAY WE USE LIST ITEM FROM SCRAP VIEW AND RECYCLE IT.

        //Listview setadapter takes listaddapter as argument,base adapter implemnts listadapter,and array adapter extends base adapter.
        //GridView gridview = (GridView) findViewById(R.id.grid_view);
        //gridview.setAdapter(itemsAdapter);
        // SAME FOR GRID VIEW


        //String[] number={"HELLO","NOM"};
        // final ArrayLis numbers_english=new ArrayList<>(Arrays.list(number));

        final WordAdapter itemsAdapter = new WordAdapter(this,numbers,'n');



        ListView listview=(ListView)findViewById(R.id.list_view);
        listview.setAdapter(itemsAdapter);

     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Words words=itemsAdapter.getItem(position);//DEFINED IN ARRAYADDAPTER
            // Words words=numbers.get(position); DEFINED IN ARRAYLIST
             mediaPlayer = MediaPlayer.create(getApplicationContext(),words.getAudio());
             mediaPlayer.start();
             mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
             {
                 @Override
                 public void onCompletion(MediaPlayer mp) {
                     mediaPlayer.release();
                 }
             });

         }
     });

    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
