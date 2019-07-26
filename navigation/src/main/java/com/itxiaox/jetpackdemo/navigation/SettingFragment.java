package com.itxiaox.jetpackdemo.navigation;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itxiaox.android.xutils.log.LogUtils;
import com.itxiaox.navigation.R;

public class SettingFragment extends DialogFragment {
    private static final String TAG = "SettingFragment";
    View view;
    TextView tv_show;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      LogUtils.i(TAG+";onCreateView");
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        tv_show = view.findViewById(R.id.tv_show);
        Bundle bundle = getArguments();
        if(bundle!=null){
            tv_show.setText(tv_show.getText().toString().trim()+";从前个fragment中取得："+bundle.getString("key1"));
        }
        return view;
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
