package com.example.android.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class BasicWordsActivity extends AppCompatActivity {

    final Context c = this;
    public LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Tour> words = new ArrayList<Tour>();
        words.add(new Tour(getString(R.string.h1m), getString(R.string.h1d), R.drawable.amberton));
        words.add(new Tour(getString(R.string.h2m), getString(R.string.h2d), R.drawable.ararat));
        words.add(new Tour(getString(R.string.h3m), getString(R.string.h3d), R.drawable.euterpe));
        words.add(new Tour(getString(R.string.h4m), getString(R.string.h4d), R.drawable.dunetton));
        words.add(new Tour(getString(R.string.h5m), getString(R.string.h5d), R.drawable.michaelson));
        words.add(new Tour(getString(R.string.h6m), getString(R.string.h6d), R.drawable.nationalhotel));


        TourAdapter itemsAdapter = new TourAdapter(this, words, R.color.Translation);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Tour word = words.get(position);
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.info_activity, null);
                TextView TextName = (TextView) mView.findViewById(R.id.textName);
                TextName.setText(word.getMainWord());
                TextView TextInfo = (TextView) mView.findViewById(R.id.allertMessage);
                TextInfo.setText(word.getDescription());
                ImageView ImageInfo = (ImageView) mView.findViewById(R.id.allertImage);
                ImageInfo.setImageResource(word.getImageResourceId());
                ScrollView ScrollInfo = (ScrollView) mView.findViewById(R.id.custom_dialog_layout_design_user_input);
                ScrollInfo.setBackgroundResource(R.color.Translation);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);
                alertDialogBuilderUserInput
                        .setCancelable(true);
                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();

            }
        });
    }
}
