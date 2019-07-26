package com.itxiaox.lifecycle.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.annotation.MainThread;

public class MainViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> tokens;

    public LiveData<String> getTokens(){
        if (tokens == null){
            tokens = new MutableLiveData<>();
            loadToken();
        }
        return tokens;
    }

    public void setTokens(String token){
        tokens.setValue(token);
    }

    @MainThread
    public void setTokensInMainThread(String token){
        tokens.postValue(token);//在主线程中更新数据
    }

    public void loadToken(){
        //from webservice
         // 比如登录获取token，然后保存到MainViewModel中
        String token = "1234567";
        tokens.setValue(token);
    }
}
