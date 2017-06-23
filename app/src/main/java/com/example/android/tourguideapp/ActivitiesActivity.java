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

public class ActivitiesActivity extends AppCompatActivity {

    final Context c = this;
    public LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Tour> words = new ArrayList<Tour>();
        //museums list
        words.add(new Tour(getString(R.string.m1m), getString(R.string.m1d), R.drawable.blacksmith));
        words.add(new Tour(getString(R.string.m2m), getString(R.string.m2d), R.drawable.castlemuseum));
        words.add(new Tour(getString(R.string.m3m), getString(R.string.m3d), R.drawable.klaipedamap));
        words.add(new Tour(getString(R.string.m4m), getString(R.string.m4d), R.drawable.clockmuseum));
        words.add(new Tour(getString(R.string.m5m), getString(R.string.m5d), R.drawable.minorhistory));
        //words.add(new Tour(getString(R.string.m6m), getString(R.string.m6d)));


        TourAdapter itemsAdapter = new TourAdapter(this, words, R.color.Activities);

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
                ScrollInfo.setBackgroundResource(R.color.Activities);
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
