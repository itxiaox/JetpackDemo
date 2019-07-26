package com.itxiaox.jetpackdemo.navigation;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.itxiaox.android.xutils.log.LogUtils;
import com.itxiaox.navigation.R;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";
    View view;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.i(TAG+";onCreateView");
        view = inflater.inflate(R.layout.fragment_main, container, false);

        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_oneFragment);
            }
        });
        view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key1","value1");
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_settingFragment,bundle);
                //无效？？ 官网的方法无效
//                Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_settingFragment,null);
            }
        });
        textView = view.findViewById(R.id.textView);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key2","value2");
                 //方法一，没有定义action也可用，
//                Navigation.findNavController(view).navigate(R.id.bottom_activity,bundle);//ResId: nav_graph 中定义的id
                 //方法二，在nav_graph中定义了action（action_mainFragment_to_bottom_activity）后，可以采用此方法 ，
                // 一般建议定义action这样，可以通过nav_graph图形预览看到各个页面对象的关系
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_bottom_activity,bundle);

            }
        });
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
