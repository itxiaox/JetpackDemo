package com.itxiaox.jetpackdemo.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.itxiaox.navigation.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);

//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
//        NavigationUI.setupWithNavController(bottomNav,navController);


//        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                Toast.makeText(MainActivity.this, ""+menuItem.getTitle(), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

    }
}
