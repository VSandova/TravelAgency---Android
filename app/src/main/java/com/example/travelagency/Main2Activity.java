package com.example.travelagency;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Main2Activity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Button ButtonR;
    private ImageView imgOne, imgTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//framelayout
        imgOne = findViewById(R.id.img1);
        imgTwo = findViewById(R.id.img2);

        myListener();

//endframe
        ButtonR = (Button) findViewById(R.id.btnR);
        ButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLowViewActivity = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intentLowViewActivity);
            }
        });


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//frame

    private void myListener() {
        imgOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgOne.setVisibility(View.GONE);
                imgTwo.setVisibility(View.VISIBLE);
            }
        });
        imgTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgOne.setVisibility(View.VISIBLE);
                imgTwo.setVisibility(View.GONE);

            }
        });


    }
}
