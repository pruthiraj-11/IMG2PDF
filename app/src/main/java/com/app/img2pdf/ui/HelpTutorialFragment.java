package com.app.img2pdf.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.img2pdf.R;
import com.app.img2pdf.databinding.FragmentHelpTutorialBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class HelpTutorialFragment extends Fragment {
    private FragmentHelpTutorialBinding binding;

    public HelpTutorialFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        watchYoutubeVideo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentHelpTutorialBinding.inflate(inflater,container,false);

        NavigationView navigationView = requireActivity().findViewById(R.id.nav_view);

        return binding.getRoot();
    }

    public void watchYoutubeVideo() {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + "CtjJ5HTYZ_k"));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + "CtjJ5HTYZ_k"));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }

}