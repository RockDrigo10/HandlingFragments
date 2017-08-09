package com.example.admin.handlingfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener{
    private static final String RED_FRAGMENT_TAG = "RedFragment";
    private static final String YELLOW_FRAGMENT_TAG = "YellowFragment";
    private static final String BLUE_FRAGMENT_TAG = "BlueFragment";
    FrameLayout flFragment;
    Button btnAddFrag,btnAddYellow,btnAddBlue,btnRemove,btnRemoveRed;
    TextView tvBlue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flFragment = (FrameLayout) findViewById(R.id.flFragment);
        btnAddFrag = (Button) findViewById(R.id.btnAddFrag);
        btnAddYellow = (Button) findViewById(R.id.btnAddYellow);
        btnAddBlue = (Button) findViewById(R.id.btnAddBlue);
        btnRemoveRed = (Button) findViewById(R.id.btnRemoveRed);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        tvBlue = (TextView) findViewById(R.id.tvBlue);
    }

    public void addFragment(View view) {
        switch (view.getId()){
            case R.id.btnAddFrag:
                RedFragment fragment =  new RedFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flFragment,fragment,RED_FRAGMENT_TAG)
                        .addToBackStack(RED_FRAGMENT_TAG)
                        .commit();
                break;
            case R.id.btnAddYellow:
                YellowFragment  yellowFragment = YellowFragment.newInstance("Rodrigo", "Chavez");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,yellowFragment,YELLOW_FRAGMENT_TAG)
                        .addToBackStack(YELLOW_FRAGMENT_TAG)
                        .commit();
                break;
            case R.id.btnAddBlue:
                BlueFragment  blueFragment = BlueFragment.newInstance("Rodrigo", "Chavez");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,blueFragment,BLUE_FRAGMENT_TAG)
                        .addToBackStack(BLUE_FRAGMENT_TAG)
                        .commit();
                break;
            case R.id.btnRemove:
                while(getSupportFragmentManager().getBackStackEntryCount()>0){
                    getSupportFragmentManager().popBackStackImmediate();
                }
                break;
            case R.id.btnRemoveRed:
                    Fragment redFragment = getSupportFragmentManager().findFragmentByTag(RED_FRAGMENT_TAG);
                    getSupportFragmentManager().beginTransaction()
                            .remove(redFragment)
                            .commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //finish();
    }

    @Override
    public void onFragmentInteraction(String string) {
        tvBlue.setText(string);
    }
}
