package com.example.travelagency;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private List<Slide> lstSlide;
    private ViewPager sliderpager;
    private LinearLayout LayoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutButton = (LinearLayout) findViewById(R.id.layoutAlbania);
        LayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLowViewActivity = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intentLowViewActivity);
            }
        });


        //Spinner
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Spinner mSpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.transport));
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);
//end spinner

//slide
        sliderpager = findViewById(R.id.sldier_pager);
        lstSlide = new ArrayList<>();
        lstSlide.add(new Slide(R.drawable.istanbul, "Екскурзия до Истанбул - 5 дни / Само сега за 300 лв."));
        lstSlide.add(new Slide(R.drawable.parij1, "Екскурзия до Париж за ценители - 8 дни / Само сега за 1300лв"));
        lstSlide.add(new Slide(R.drawable.london, "Предколедна екскурзия до Лондон - 8 дни / Само сега за 1600лв"));
        lstSlide.add(new Slide(R.drawable.istanbul, "Екскурзия до Истанбул - 5 дни / Само сега за 300 лв."));
        lstSlide.add(new Slide(R.drawable.parij1, "Екскурзия до Париж за ценители - 8 дни / Само сега за 1300лв\""));
        lstSlide.add(new Slide(R.drawable.london, "Предколедна екскурзия до Лондон - 8 дни / Само сега за 1600лв"));


        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlide);
        sliderpager.setAdapter(adapter);


//menu
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.navigation);
        setupDrawerContent(nvDrawer);
    }


    private void setupDrawerContent(NavigationView navigationView) {
                        navigationView.setNavigationItemSelectedListener(
                                new NavigationView.OnNavigationItemSelectedListener() {
                                    @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    // Handle navigation view item clicks here.
                    int id = item.getItemId();

                    if (id == R.id.Contact) {
                        Intent intentLowViewActivity = new Intent(MainActivity.this, Main4Activity.class);
                        startActivity(intentLowViewActivity);

                    }

                    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }

    });

}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    }
