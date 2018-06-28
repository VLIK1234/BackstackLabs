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
import com.example.bakachie.backstacklabs.data.StackBehaviour;

public abstract class BaseFragment extends Fragment {

    private String m_currentFragment;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        m_currentFragment = this.getClass().getName();
        Button secondFragment = view.findViewById(R.id.bt_next_fragment);
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFragment();
            }
        });

        if (StackBehaviour.needToBeMissed(m_currentFragment)) {
            nextFragment();
        }
    }

    private void nextFragment() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FragmentManager fm = activity.getSupportFragmentManager();

            boolean needToBeMissed = StackBehaviour.needToBeMissed(m_currentFragment);

            if (needToBeMissed) {
                fm.popBackStack();
            }

            fm.beginTransaction()
                    .replace(R.id.fragment_container, Fragment.instantiate(activity, nextFragmentName()), nextFragmentName())
                    .addToBackStack(nextFragmentName())
                    .commit();
        }
    }

    protected abstract String nextFragmentName();
}
