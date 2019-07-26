package com.itxiaox.lifecycle.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 这里对setdata进行判断，防止重复设置数据
 */
class BaseViewModel extends ViewModel {

    //Set value while different.
    //DO NOT use this while oldValue and newValue are the same object!!!
    <T> void setDataValue(MutableLiveData<T> data, T newValue) {
        T oldValue = data.getValue();
        if (oldValue == null || !oldValue.equals(newValue)) {
            data.setValue(newValue);
        }
    }

    //clear value
    <T> void clearDataValue(MutableLiveData<T> data) {
        data.setValue(null);
    }
}
