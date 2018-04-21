package com.example.android.herome.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.herome.Fragments.MainFragment;
import com.example.android.herome.Fragments.PickPowerFragment;
import com.example.android.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager=getSupportFragmentManager();
        Fragment fragment= manager.findFragmentById(R.id.fragment_container);

        if(fragment==null){
            fragment=new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
            //grabing the manager,begin transaction and end it by commiting--can bedone in 3 parts
        }
    }
    public void loadPickPowerScreen(){
        PickPowerFragment pickPowerFragment=new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();

        //addToBackStack reverses the fragment..no need to do it manually

        /*merging two fragments --:
         getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,pickPowerFragment).commit();
        */
    }

    @Override
    public void onMainFragmentInteractionListener(Uri uri) {

    }

    @Override
    public void onPickPowerInteraction(Uri uri) {

    }
}
