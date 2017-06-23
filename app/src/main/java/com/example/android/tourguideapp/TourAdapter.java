package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lukas on 2017-06-21.
 */

public class TourAdapter extends ArrayAdapter<Tour> {
    private static final String LOG_TAG = TourAdapter.class.getSimpleName();
    private int mColorResourceId;

    public TourAdapter(Activity context, ArrayList<Tour> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link English word} object located at this position in the list
        Tour currentEnglishWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView MainWordText = (TextView) listItemView.findViewById(R.id.Main_word);
        // Get the word from current english object and
        // set this text on the name TextView
        MainWordText.setText(currentEnglishWord.getMainWord());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView descriptionText = (TextView) listItemView.findViewById(R.id.Description);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        descriptionText.setText(currentEnglishWord.getDescription());

        ImageView defaultImage = (ImageView) listItemView.findViewById(R.id.Image_View);


        defaultImage.setImageResource(currentEnglishWord.getImageResourceId());


        // Check if an image is provided for this word or not

        View listViewColor = listItemView.findViewById(R.id.ListCollorLinear);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        listViewColor.setBackgroundColor(color);


        return listItemView;
    }


}
