package com.itxiaox.jetpackdemo.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itxiaox.navigation.R;

public class SettingFragment extends DialogFragment {
    View view;
    TextView tv_show;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        tv_show = view.findViewById(R.id.tv_show);
        Bundle bundle = getArguments();
        if(bundle!=null){
            tv_show.setText(tv_show.getText().toString().trim()+";从前个fragment中取得："+bundle.getString("key1"));
        }



        return view;

    }
}
