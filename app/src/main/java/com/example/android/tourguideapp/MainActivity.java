package com.example.android.tourguideapp;

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

        // Find the View that shows the numbers category
        TextView places = (TextView) findViewById(R.id.places);

// Set a click listener on that View
        places.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, PlacesActivity.class);
                startActivity(phrasesIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView restaurants = (TextView) findViewById(R.id.Restaurants);

// Set a click listener on that View
        restaurants.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent restaurantsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(restaurantsIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView Activities = (TextView) findViewById(R.id.Activities);

// Set a click listener on that View
        Activities.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent activitiesIntent = new Intent(MainActivity.this, ActivitiesActivity.class);
                startActivity(activitiesIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView basicWords = (TextView) findViewById(R.id.Hotels);

// Set a click listener on that View
        basicWords.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent basicIntent = new Intent(MainActivity.this, BasicWordsActivity.class);
                startActivity(basicIntent);
            }
        });
    }
}
