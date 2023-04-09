package com.example.bttuan5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    EditText emailEditText;
    EditText phoneEditText;
    RadioGroup genderRadioGroup;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                int genderId = genderRadioGroup.getCheckedRadioButtonId();
                String gender = "";
                if (genderId == R.id.maleRadioButton) {
                    gender = "Male";
                } else if (genderId == R.id.femaleRadioButton) {
                    gender = "Female";
                }

                if (validateInput(username, password, confirmPassword, email, phone, gender)) {
                    SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.putString("email", email);
                    editor.putString("phone", phone);
                    editor.putString("gender", gender);
                    editor.apply();

                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validateInput(String username, String password, String confirmPassword, String email, String phone, String gender) {
        // TODO: Add input validation logic here
        return true;
    }
}