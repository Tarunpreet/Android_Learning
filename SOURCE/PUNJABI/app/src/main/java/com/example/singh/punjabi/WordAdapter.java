package com.example.singh.punjabi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SINGH on 24/10/17.
 *
 **/

public class WordAdapter extends ArrayAdapter<Words> {

private final char activity;
    public WordAdapter(Activity context, ArrayList<Words> words,char activity)
    {
        super(context,0,words);
        this.activity=activity;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Words word=getItem(position);
        View view=convertView;

            if (view == null&&activity=='n')
            {
                LayoutInflater inflater=LayoutInflater.from(getContext());
                view = inflater.inflate(R.layout.killer_ll, parent, false);

            }

            if(view==null&&activity=='f')
            {
                LayoutInflater inflater=LayoutInflater.from(getContext());
                view = inflater.inflate(R.layout.killer_ll, parent, false);
            }
            TextView first = (TextView) view.findViewById(R.id.punjabi_View);
            TextView second = (TextView) view.findViewById(R.id.english_view);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            first.setText(word.getPunjabi_word());
            second.setText(word.getEnglish_word());
            imageView.setImageResource(word.getImages());

            return view;

    }



}
