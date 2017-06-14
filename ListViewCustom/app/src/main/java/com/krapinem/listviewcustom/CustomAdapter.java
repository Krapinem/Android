package com.krapinem.listviewcustom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, String[] fruits) {
        super(context ,R.layout.custom_row , fruits);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = LayoutInflater.from(getContext());
        View customView = mInflater.inflate(R.layout.custom_row,parent,false);

        String fruit = getItem(position);
        TextView mtextView = (TextView) customView.findViewById(R.id.itemText);
        ImageView mImageView = (ImageView) customView.findViewById(R.id.imageView);

        mtextView.setText(fruit);
        mImageView.setImageResource(R.drawable.image);

        return customView;
    }
}
