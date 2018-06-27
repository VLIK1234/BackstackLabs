package com.example.bakachie.backstacklabs.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import com.example.bakachie.backstacklabs.R;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final String name = this.getClass().getName();
        Button secondFragment = view.findViewById(R.id.bt_next_fragment);
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    FragmentManager fm = activity.getSupportFragmentManager();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, Fragment.instantiate(activity, nextFragmentName()), nextFragmentName())
                            .addToBackStack(name)
                            .commit();
                }
            }
        });
    }

//    protected abstract String currentFragmentName();

    protected abstract String nextFragmentName();
}
