package com.itxiaox.lifecycle.ui.main;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/**
 * 重写ViewModelProvider，创建一个与Application等长的ViewModel
 */
public class JSViewModelProvider extends ViewModelProvider {
    private static JSViewModelProvider mInstance;
    private static ViewModelStoreOwner mOwner;

    @MainThread
    public static void initialize(ViewModelStoreOwner owner) {
        mOwner = owner;
    }

    //Should be called by Application only.
    @MainThread
    public static void terminate() {
        mOwner = null;
        mInstance = null;
    }

    public static JSViewModelProvider getInstance() {
        if (mInstance != null) return mInstance;
        if (mOwner == null) {
            throw new IllegalStateException("No owner, not initialized YET.");
        }
        else {
            synchronized (JSViewModelProvider.class) {
                mInstance = new JSViewModelProvider(mOwner, new NewInstanceFactory());
                return mInstance;
            }
        }
    }

    @NonNull
    @MainThread
    public static <T extends ViewModel> T getModel(@NonNull Class<T> modelClass) {
        return getInstance().get(modelClass);
    }

    @MainThread
    private JSViewModelProvider(@NonNull ViewModelStoreOwner owner, @NonNull Factory factory) {
        super(owner, factory);
    }
}
