package com.example.ataher.studygroups;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ataher.studygroups.Helper.HelperMethods;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);
        TextView textView = (TextView) hView.findViewById(R.id.textView);
        de.hdodenhof.circleimageview.CircleImageView imagee = (de.hdodenhof.circleimageview.CircleImageView) hView.findViewById(R.id.profile_image);
        TextView profile_name = (TextView) hView.findViewById(R.id.profile_name);
//        textView.setText(HelperMethods.currentUserEmail);
//        imagee.setImageBitmap(HelperMethods.bitmmapimageuser);
//        profile_name.setText(HelperMethods.currentUsername);
        navigationView.setNavigationItemSelectedListener(this);


    }

    public void feedback(View v) {
        Intent intent = new Intent(Home.this, FeedBack.class);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }


    }

    public void search(View view) {


        Intent intent = new Intent(this, GroupSearch.class);
        startActivity(intent);
    }

   public void about_home(View view) {
        Intent intent = new Intent(this, about_home.class);
        startActivity(intent);
    }

    public void groups(View view) {
        Intent intent = new Intent(this, Mygroups.class);
        startActivity(intent);
    }


    public void contactuus(View view) {
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.refresh) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(Home.this, Update_Userinfo.class);
            startActivity(intent);
        } else if (id == R.id.nav_search) {
            Intent intent = new Intent(Home.this, GroupSearch.class);
            startActivity(intent);

        }  else if (id == R.id.nav_exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(Home.this, LoginScreen.class);
            startActivity(intent);

        } else if (id == R.id.nav_about_sh) {
            Intent intent = new Intent(Home.this, about_sha.class);
            startActivity(intent);

        } else if (id == R.id.nav_about_sg) {
            Intent intent = new Intent(Home.this, about_sg.class);
            startActivity(intent);

        } else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(Home.this, FeedBack.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void app1(View view) {

        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=iitg.lastsem.manparvesh.iitgstudygroups");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void app2(View view) {

        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=vh.frl.stopwatch");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void app3(View view) {

        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.studygroup.coursefinder");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void team(View v) {
        startActivity(new Intent(Home.this, OurtTeam.class));
    }


}
