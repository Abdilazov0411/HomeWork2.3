package com.example.homework23;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.homework23.databinding.FragmentFirstBinding;
import com.example.homework23.databinding.FragmentSecondBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnCount.setOnClickListener(view1 -> {
            counter++;
        });

        binding.btnSlide.setOnClickListener(view1 -> {

            SecondFragment resultFragment = new SecondFragment();
            Bundle bundle = new Bundle();
            bundle.putString("KEY", String.valueOf(counter));
            resultFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_first, resultFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}