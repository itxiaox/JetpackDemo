package com.itxiaox.workmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        UploadTaskManager.startUploadTask(getApplicationContext(),true);
    }

    public void stop(View view) {
        UploadTaskManager.stop(getApplicationContext());
    }
}
