package com.itxiaox.jetpackdemo.navigation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.itxiaox.android.xutils.log.LogUtils;
import com.itxiaox.navigation.R;

public class OneFragment extends Fragment {

    private static final String TAG = "OneFragment";
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);

        view.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTwoFragment(v);
            }
        });
        view.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goThreeFragment(v);
            }
        });
        return view;
    }

    public void goTwoFragment(View view){

        //todo safeArgs 的使用？
        Navigation.findNavController(view).navigate(R.id.action_oneFragment_to_twoFragment);
    }

    public void goThreeFragment(View view){
        Bundle bundle = new Bundle();
        bundle.putString("name","张山");
        Navigation.findNavController(view).navigate(R.id.action_oneFragment_to_threeFragment,bundle);
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
