package com.example.accounts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;

import android.os.Bundle;
import android.widget.Toast;

import auth.biometric;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BiometricManager biometricManager = BiometricManager.from(this);
        if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG | BiometricManager.Authenticators.DEVICE_CREDENTIAL) == BiometricManager.BIOMETRIC_SUCCESS) {
            biometric.authenticateUser(this);
        } else {
            Toast.makeText(this, "Biometric authentication not available", Toast.LENGTH_SHORT).show();
        }
    }
}