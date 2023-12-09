package com.app.img2pdf.ui.rateappfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.app.img2pdf.R;
import com.app.img2pdf.databinding.FragmentRateAppBinding;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.Task;

public class RateAppFragment extends Fragment {

    private FragmentRateAppBinding binding;
    private ReviewManager reviewManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRateAppBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        reviewManager = ReviewManagerFactory.create(requireContext());
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setCancelable(false);
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_dialog_rate_app, null);
        builder.setView(customLayout);
        builder.setPositiveButton("Rate 5 star", (dialog, which) -> {
            showRateApp();
        });
        builder.setNegativeButton("Not now", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
        return root;
    }

    public void showRateApp() {
        Task<ReviewInfo> request = reviewManager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ReviewInfo reviewInfo = task.getResult();
                Task <Void> flow = reviewManager.launchReviewFlow(requireActivity(), reviewInfo);
                flow.addOnCompleteListener(task1 -> {

                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(requireActivity(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}