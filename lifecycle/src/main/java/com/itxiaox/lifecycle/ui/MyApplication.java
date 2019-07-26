package com.itxiaox.lifecycle.ui;

import android.app.Application;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.annotation.NonNull;

import com.itxiaox.lifecycle.ui.main.JSViewModelProvider;

public class MyApplication extends Application implements ViewModelStoreOwner {
    private ViewModelStore mViewModelStore = null;
    @Override
    public void onCreate() {
        super.onCreate();

        JSViewModelProvider.initialize(this);
    }

    @Override
    public void onTerminate() {

        JSViewModelProvider.terminate();
        super.onTerminate();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        if (mViewModelStore == null) {
            mViewModelStore = new ViewModelStore();
        }
        return mViewModelStore;
    }
}
