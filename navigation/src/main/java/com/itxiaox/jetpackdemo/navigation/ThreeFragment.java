package com.itxiaox.jetpackdemo.navigation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.itxiaox.android.xutils.log.LogUtils;
import com.itxiaox.navigation.R;

public class ThreeFragment extends Fragment {

    private static final String TAG = "ThreeFragment";

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_three, container, false);


        String name = getArguments().getString("name");
        TextView textView = view.findViewById(R.id.textView4);
        textView.setText("Three-"+name);
        view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMainFragment(v);
            }
        });
        return view;
    }


    public void goMainFragment(View view){
        Navigation.findNavController(view).navigate(R.id.action_threeFragment_mainFragment);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(TAG+";onCreate");
    }

    @Override
    public void onStart() {
        LogUtils.i(TAG+";onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i(TAG+";onPause");
    }


    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i(TAG+";onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG+";onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtils.i(TAG+";onConfigurationChanged="+newConfig);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtils.i(TAG+";onHiddenChanged="+hidden);
    }
}
