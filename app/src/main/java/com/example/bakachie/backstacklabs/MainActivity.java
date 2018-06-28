package com.example.bakachie.backstacklabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.bakachie.backstacklabs.fragment.FirstFragment;
import com.example.bakachie.backstacklabs.fragment.RemoteFragment;

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
}
