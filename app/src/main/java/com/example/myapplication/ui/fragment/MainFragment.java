package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.myapplication.R;

/**
 * Created by new on 2014/12/18.
 */
public class MainFragment extends Fragment {

    private View mCurrentView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCurrentView= inflater.inflate(R.layout.fragment_content,null);

        return mCurrentView;
    }

    public FrameLayout.LayoutParams getCurrentViewParams(){
        return (FrameLayout.LayoutParams) mCurrentView.getLayoutParams();
    }

    public void setCurrentViewParams(FrameLayout.LayoutParams layoutParams){
        mCurrentView.setLayoutParams(layoutParams);
    }
}
