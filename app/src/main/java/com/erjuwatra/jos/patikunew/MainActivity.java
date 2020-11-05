package com.erjuwatra.jos.patikunew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    Dashboard fraghome;
    News fragnews;
//    Search fragsearch;
    Kuliner fragkuliner;
    Wisata fragwisata;

    MenuItem menuItem;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout =  findViewById(R.id.drawer_layout);

        viewPager = findViewById(R.id.pager);
        setupViewPager(viewPager);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.news:
                        viewPager.setCurrentItem(1);
                        break;
//                    case R.id.search:
//                        viewPager.setCurrentItem(2);
//                        break;
                    case R.id.kuliner:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.traveling:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fraghome = new Dashboard();
        fragnews = new News();
//        fragsearch = new Search();
        fragkuliner = new Kuliner();
        fragwisata = new Wisata();


        adapter.addFragment(fraghome);
        adapter.addFragment(fragnews);
//        adapter.addFragment(fragsearch);
        adapter.addFragment(fragkuliner);
        adapter.addFragment(fragwisata);
viewPager.setAdapter(adapter);



    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);

    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }

    public void ClickHome(View view){
        redirectActivity(this, Dashboardnya.class);
    }

    public void ClickAbout(View view){
        redirectActivity(this, About.class);
    }



    public static void redirectActivity(Activity activity,Class aClass) {

        Intent intent = new Intent(activity,aClass);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        activity.startActivity(intent);

    }
}