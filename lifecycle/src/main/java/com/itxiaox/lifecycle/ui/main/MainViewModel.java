package com.itxiaox.lifecycle.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> tokens;

    public MutableLiveData<String> getTokens(){
        if (tokens == null){
            tokens = new MutableLiveData<>();
            loadToken();
        }
        return tokens;
    }

    public void loadToken(){
        //from webservice
         //
        String token = "1234567";
        tokens.setValue(token);
    }
}
