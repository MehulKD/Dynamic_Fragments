package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FarazAhmed on 6/7/2017.
 */

public class BodyPartFragment extends android.support.v4.app.Fragment {

    public static final String IMAGES_ID = "images_id";
    public static final String INDEX = "index";
    private List<Integer> mImageList;
    private int index;

    public BodyPartFragment() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGES_ID, (ArrayList<Integer>) mImageList);
        outState.putInt(INDEX,index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(savedInstanceState !=null)
        {
            mImageList = savedInstanceState.getIntegerArrayList(IMAGES_ID);
            index = savedInstanceState.getInt(INDEX);
        }

        View rootview = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) rootview.findViewById(R.id.imageview);
        imageView.setImageResource(mImageList.get(index));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < mImageList.size() - 1) {
                    index++;
                } else {
                    index = 0;
                }
                imageView.setImageResource(mImageList.get(index));
            }
        });
        return rootview;
    }

    public void setmImageList(List<Integer> mImageList) {
        this.mImageList = mImageList;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
