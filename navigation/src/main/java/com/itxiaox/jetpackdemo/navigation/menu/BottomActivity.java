package com.itxiaox.jetpackdemo.navigation.menu;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

import com.itxiaox.android.xutils.log.LogUtils;
import com.itxiaox.navigation.R;

public class BottomActivity extends AppCompatActivity {
    private static final String TAG = "BottomActivity";
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtils.i(TAG+";onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        Bundle bundle = getIntent().getExtras();
        mTextMessage.setText(bundle.getString("key2"));
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(TAG+";onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG+";onDestroy");
    }
}
