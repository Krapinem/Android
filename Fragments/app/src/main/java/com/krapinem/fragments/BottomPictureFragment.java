package com.krapinem.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomPictureFragment extends Fragment{

    TextView mtop,mbottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.bottom_picture_fragment,container,false);
        mtop = (TextView) mView.findViewById(R.id.topText);
        mbottom = (TextView) mView.findViewById(R.id.bottomText);
        return mView;
    }

    public void setText(String top,String bottom)
    {
        mtop.setText(top);
        mbottom.setText(bottom);
    }
}
