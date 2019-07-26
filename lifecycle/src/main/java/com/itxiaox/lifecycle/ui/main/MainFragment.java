package com.itxiaox.lifecycle.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itxiaox.lifecycle.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //这里使用的是ViewModelProviders，当前ViewModel的生命周期长度和Activity等长
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        //通过JSViewModelProvider 获取viewModel，这时候的ViewModel的生命周期和Application等长
        mViewModel = JSViewModelProvider.getModel(MainViewModel.class);

        // TODO: Use the ViewModel
        mViewModel.getTokens().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
