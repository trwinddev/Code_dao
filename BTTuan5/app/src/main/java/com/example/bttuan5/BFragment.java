package com.example.bttuan5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BFragment extends Fragment {
    TextView usernameTextView;
    TextView emailTextView;
    TextView phoneTextView;
    TextView genderTextView;
    Button logoutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        usernameTextView = view.findViewById(R.id.usernameTextView);
        emailTextView = view.findViewById(R.id.emailTextView);
        phoneTextView = view.findViewById(R.id.phoneTextView);
        genderTextView = view.findViewById(R.id.genderTextView);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String phone = sharedPreferences.getString("phone", "");
        String gender = sharedPreferences.getString("gender", "");

        usernameTextView.setText("Username: " + username);
        emailTextView.setText("Email: " + email);
        phoneTextView.setText("Phone: " + phone);
        genderTextView.setText("Gender: " +gender);


        return view;
    }
}