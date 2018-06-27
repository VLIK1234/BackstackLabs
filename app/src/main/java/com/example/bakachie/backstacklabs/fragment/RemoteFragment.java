package com.example.bakachie.backstacklabs.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bakachie.backstacklabs.R;

public class RemoteFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_remote, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.to_first).setOnClickListener(this);
        view.findViewById(R.id.to_second).setOnClickListener(this);
        view.findViewById(R.id.to_third).setOnClickListener(this);
        view.findViewById(R.id.to_forth).setOnClickListener(this);
        view.findViewById(R.id.open_first).setOnClickListener(this);
        view.findViewById(R.id.open_second).setOnClickListener(this);
        view.findViewById(R.id.open_third).setOnClickListener(this);
        view.findViewById(R.id.open_forth).setOnClickListener(this);
        view.findViewById(R.id.remove_first).setOnClickListener(this);
        view.findViewById(R.id.remove_second).setOnClickListener(this);
        view.findViewById(R.id.remove_third).setOnClickListener(this);
        view.findViewById(R.id.remove_forth).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_first:
                popTo(FirstFragment.class.getName());
                break;
            case R.id.to_second:
                popTo(SecondFragment.class.getName());
                break;
            case R.id.to_third:
                popTo(ThirdFragment.class.getName());
                break;
            case R.id.to_forth:
                popTo(ForthFragment.class.getName());
                break;
            case R.id.open_first:
                open(FirstFragment.class.getName());
                break;
            case R.id.open_second:
                open(SecondFragment.class.getName());
                break;
            case R.id.open_third:
                open(ThirdFragment.class.getName());
                break;
            case R.id.open_forth:
                open(ForthFragment.class.getName());
                break;
            case R.id.remove_first:
                remove(FirstFragment.class.getName());
                break;
            case R.id.remove_second:
                remove(SecondFragment.class.getName());
                break;
            case R.id.remove_third:
                remove(ThirdFragment.class.getName());
                break;
            case R.id.remove_forth:
                remove(ForthFragment.class.getName());
                break;
        }
    }

    private void popTo(final String fragmentName) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getSupportFragmentManager().popBackStack(fragmentName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    private String previousFragment;

    private void open(final String fragmentName) {
        FragmentActivity activity = getActivity();

        if (activity != null) {
            FragmentManager fm = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction
                    .replace(R.id.fragment_container, Fragment.instantiate(activity, fragmentName), fragmentName);
            fragmentTransaction.addToBackStack(previousFragment);
//            if (!TextUtils.isEmpty(previousFragment)) {
//                fragmentTransaction.addToBackStack(previousFragment);
//            }
            fragmentTransaction.commit();
            previousFragment = fragmentName;
        }
    }

    private void remove(final String fragmentName) {
        FragmentActivity activity = getActivity();

        if (activity != null) {
            FragmentManager fm = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction
                    .remove(fm.findFragmentByTag(fragmentName))
                    .commit();
        }
    }
}
