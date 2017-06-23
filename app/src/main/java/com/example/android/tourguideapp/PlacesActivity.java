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

public class PlacesActivity extends AppCompatActivity {

    final Context c = this;
    public LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Tour> words = new ArrayList<Tour>();
        words.add(new Tour(getString(R.string.p1m), getString(R.string.p1d), R.drawable.septyniolik));
        words.add(new Tour(getString(R.string.p2m), getString(R.string.p2d), R.drawable.menu_kiemas));
        words.add(new Tour(getString(R.string.p3m), getString(R.string.p3d), R.drawable.cathedral_square));
        words.add(new Tour(getString(R.string.p4m), getString(R.string.p4d), R.drawable.jonashill));
        words.add(new Tour(getString(R.string.p5m), getString(R.string.p5d), R.drawable.dinos));
        words.add(new Tour(getString(R.string.p6m), getString(R.string.p6d), R.drawable.lithuanian_sea_museum));


        TourAdapter itemsAdapter = new TourAdapter(this, words, R.color.Places);

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
                ScrollInfo.setBackgroundResource(R.color.Places);
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
