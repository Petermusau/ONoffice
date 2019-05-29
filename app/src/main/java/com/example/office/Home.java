package com.example.office;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Home extends AppCompatActivity implements Staff.OnFragmentInteractionListener,Goods.OnFragmentInteractionListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TabLayout tabLayout =(TabLayout)findViewById(R.id.tablelayout);
        tabLayout.addTab(tabLayout.newTab().setText("Staff"));
        tabLayout.addTab(tabLayout.newTab().setText("Goods"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.bottom_home:
                        setTitle(menuItem.getTitle());
                        Intent i=new Intent(Home.this,Home.class);
                        startActivity(i);
                        break;
                    case R.id.bottom_cart:
                        setTitle(menuItem.getTitle());
                        Intent p=new Intent(Home.this,cart.class);
                        startActivity(p);
                        break;
                }
                return true;
            }
        });




        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    //@Override
    public void onFragmentInteraction(Uri uri) {

    }
}







