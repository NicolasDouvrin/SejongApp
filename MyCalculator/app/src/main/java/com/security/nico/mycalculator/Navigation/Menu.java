package com.security.nico.mycalculator.navigation;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import com.security.nico.mycalculator.R;
import com.security.nico.mycalculator.activities.Calculator;
import com.security.nico.mycalculator.forms.Form;
import com.security.nico.mycalculator.activities.Home;
import com.security.nico.mycalculator.activities.IsPrime;
import com.security.nico.mycalculator.activities.SQLActivity;

public class Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FirstFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_activity_0);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_activity_0:
                Intent e= new Intent(Menu.this,Home.class);
                startActivity(e);
                break;
            case R.id.nav_activity_1:
                Intent h= new Intent(Menu.this,Calculator.class);
                startActivity(h);
                break;
            case R.id.nav_activity_2:
                Intent i= new Intent(Menu.this,IsPrime.class);
                startActivity(i);
                break;
            case R.id.nav_activity_3:
                Intent j= new Intent(Menu.this,SQLActivity.class);
                startActivity(j);
                break;
            case R.id.nav_activity_4:
                Intent k= new Intent(Menu.this,Form.class);
                startActivity(k);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}



