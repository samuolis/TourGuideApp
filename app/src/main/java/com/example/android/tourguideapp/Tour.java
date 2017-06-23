package com.example.android.tourguideapp;

/**
 * Created by Lukas on 2017-06-21.
 */

public class Tour {

    private String mMainWord;
    private int mImageResourceId;
    private String mDescription;


    public Tour(String MainWord, String Description, int imageResourceId) {
        mMainWord = MainWord;
        mDescription = Description;
        mImageResourceId = imageResourceId;
    }


    public String getMainWord() {
        return mMainWord;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getDescription() {
        return mDescription;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

