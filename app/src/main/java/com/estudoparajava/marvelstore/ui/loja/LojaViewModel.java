package com.estudoparajava.marvelstore.ui.loja;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LojaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LojaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}