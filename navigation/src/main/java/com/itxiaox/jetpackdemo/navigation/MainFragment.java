package com.itxiaox.jetpackdemo.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.itxiaox.navigation.R;

public class MainFragment extends Fragment {
    View view;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_firstFragment);
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

        return view;
    }
}
