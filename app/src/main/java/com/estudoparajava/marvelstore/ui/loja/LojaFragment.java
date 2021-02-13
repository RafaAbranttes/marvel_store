package com.estudoparajava.marvelstore.ui.loja;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.estudoparajava.marvelstore.R;

public class LojaFragment extends Fragment {

    private LojaViewModel lojaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lojaViewModel =
                new ViewModelProvider(this).get(LojaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_loja, container, false);
        final ListView textView = root.findViewById(R.id.list);
        lojaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setTextFilterEnabled(Boolean.parseBoolean(s));
            }
        });
        return root;
    }
}