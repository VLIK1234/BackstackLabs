package com.example.bakachie.backstacklabs.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bakachie.backstacklabs.R;

public class FirstFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

//    @Override
//    protected String currentFragmentName() {
//        return this.currentFragmentName();
//    }

    @Override
    protected String nextFragmentName() {
        return SecondFragment.class.getName();
    }
}
