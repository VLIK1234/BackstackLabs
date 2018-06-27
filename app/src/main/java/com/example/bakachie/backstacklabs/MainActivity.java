package com.example.bakachie.backstacklabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bakachie.backstacklabs.fragment.FirstFragment;
import com.example.bakachie.backstacklabs.fragment.ForthFragment;
import com.example.bakachie.backstacklabs.fragment.RemoteFragment;
import com.example.bakachie.backstacklabs.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment instantiate = Fragment.instantiate(this, FirstFragment.class.getName());
        fm.beginTransaction()
                .add(R.id.fragment_container, instantiate, FirstFragment.class.getName())
                .commit();

        fm.beginTransaction()
                .add(R.id.bactsack_remote, Fragment.instantiate(this, RemoteFragment.class.getName()), RemoteFragment.class.getName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ForthFragment.class.getName());
//
//        if (fragment != null && fragment.isVisible()) {
//            getSupportFragmentManager().popBackStack(SecondFragment.class.getName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        } else {
//            super.onBackPressed();
//        }
    }
}
