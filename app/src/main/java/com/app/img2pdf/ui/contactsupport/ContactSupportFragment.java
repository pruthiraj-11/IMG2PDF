package com.app.img2pdf.ui.contactsupport;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.app.img2pdf.BuildConfig;
import com.app.img2pdf.R;
import com.app.img2pdf.databinding.FragmentContactSupportBinding;

public class ContactSupportFragment extends Fragment {

    private FragmentContactSupportBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContactSupportBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setCancelable(false);
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        builder.setView(customLayout);
        builder.setPositiveButton("OK", (dialog, which) -> {
            String os_version= String.valueOf(Build.VERSION.SDK_INT);
            String model_name=Build.MODEL;
            String app_version= BuildConfig.VERSION_NAME;
            String app_name= getResources().getString(R.string.app_name);
            String to="pruthiraj2002routray@gmail.com";
            String subject="IMG2PDF";
            String message="OS Version:"+os_version+"\n"+"Model:"+model_name+"\n"+"App Version:"+app_version+"\n"+"App Name:"+app_name;
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.putExtra(Intent.EXTRA_TEXT, message);
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "Choose an Email client :"));
        });
        builder.setNegativeButton("CANCEL", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}