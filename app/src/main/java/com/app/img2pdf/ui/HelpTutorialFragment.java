package com.app.img2pdf.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.img2pdf.R;
import com.app.img2pdf.databinding.FragmentHelpTutorialBinding;

public class HelpTutorialFragment extends Fragment {
    private FragmentHelpTutorialBinding binding;

    public HelpTutorialFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentHelpTutorialBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}