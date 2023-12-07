package com.app.img2pdf.ui.shareappwithfriends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.img2pdf.databinding.FragmentShareAppWithFriendsBinding;

public class ShareAppWithFriendsFragment extends Fragment {

    private FragmentShareAppWithFriendsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentShareAppWithFriendsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}