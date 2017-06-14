package com.krapinem.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Button;

public class TopSectionFragment extends Fragment {

    private static EditText topEdit,bottomEdit;
    private static Button mButton;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String topText,String bottomText);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCommander = (TopSectionListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.top_section_fragment,container,false);
        topEdit = (EditText) mView.findViewById(R.id.topEdit);
        bottomEdit = (EditText) mView.findViewById(R.id.bottomEdit);
        mButton = (Button) mView.findViewById(R.id.button);

        mButton.setOnClickListener(
               new View.OnClickListener(){
                   @Override
                   public void onClick(View v) {
                       buttonClicked(v);
                   }
               }
        );

        return mView;
    }

    private void buttonClicked(View v) {
        activityCommander.createMeme(topEdit.getText().toString(),bottomEdit.getText().toString());
    }
}
