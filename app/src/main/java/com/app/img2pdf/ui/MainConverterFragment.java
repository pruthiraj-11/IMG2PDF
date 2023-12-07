package com.app.img2pdf.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.img2pdf.R;
import com.app.img2pdf.databinding.FragmentMainConverterBinding;

public class MainConverterFragment extends Fragment {
    private FragmentMainConverterBinding binding;
    public MainConverterFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentMainConverterBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}