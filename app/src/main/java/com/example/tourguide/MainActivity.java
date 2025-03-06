package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public ActionBarDrawerToggle actionToggle;
    public DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.main_layout);
        //below code for adding hamburger in actionbar
        //actionToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        //drawerLayout.addDrawerListener(actionToggle);
        //actionToggle.syncState();
        //using actionbar
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MaterialToolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView nav = findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();
            item.setChecked(true);
            //app navbar options
            drawerLayout.closeDrawer(GravityCompat.START);
            switch (id) {

                case R.id.OPT1:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new homeFragment()).commit();
                    break;

                case R.id.OPT2:
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new restFragment()).commit();
                    break;

                case R.id.OPT3:
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new tourFragment()).commit();
                    break;

                case R.id.OPT4:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new hotelFragment()).commit();
                    break;

            }
            //item.setChecked(false);
            return true;
        });

       if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new homeFragment()).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}