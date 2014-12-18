package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

/**
 * Created by new on 2014/12/18.
 */
public class MenuFragment extends Fragment {

    private View mCurrentView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCurrentView=inflater.inflate(R.layout.fragment_menu,null);
        return mCurrentView;
    }


    public View getCurrentView(){
        return mCurrentView;
    }
}
