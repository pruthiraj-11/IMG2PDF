package com.app.img2pdf.ui.shareappwithfriends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.img2pdf.databinding.FragmentShareAppWithFriendsBinding;

public class ShareAppWithFriendsFragment extends Fragment {

    private FragmentShareAppWithFriendsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentShareAppWithFriendsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage= "I would recommend this awesome App to make PDF from images. You will like it.\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + requireContext().getPackageName();
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "Share app by..."));
        } catch(Exception e) {
            Toast.makeText(requireActivity(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}