package com.example.hdwallpaper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        setFragment(new LatesFragment());
        toolbar.setTitle(R.string.key_nav_latest);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_latest) {
            setFragment(new LatesFragment());
            toolbar.setTitle(R.string.key_nav_latest);

        } else if (id == R.id.nav_category) {
            setFragment(new CategoryFragment());
            toolbar.setTitle(R.string.key_nav_category);

        } else if (id == R.id.nav_gifs) {
            setFragment(new GifsFragment());
            toolbar.setTitle(R.string.key_nav_gifs);

        } else if (id == R.id.nav_favorites) {
            setFragment(new FavoritesFragment());
            toolbar.setTitle(R.string.key_nav_my_favorites);

        } else if (id == R.id.nav_rate) {
            setFragment(new RateFragment());
            toolbar.setTitle(R.string.key_nav_rate_app);

        } else if (id == R.id.nav_more) {
            setFragment(new MoreFragment());
            toolbar.setTitle(R.string.key_nav_more_app);

        } else if (id == R.id.nav_about) {
            setFragment(new AboutFragment());
            toolbar.setTitle(R.string.key_nav_about_us);

        } else if (id == R.id.nav_setting) {
            setFragment(new SettingFragment());
            toolbar.setTitle(R.string.key_nav_setting);

        } else if (id == R.id.nav_privacy) {
            setFragment(new PrivacyFragment());
            toolbar.setTitle(R.string.key_nav_privacy_police);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fr_home,fragment);
        ft.commit();
    }
}
