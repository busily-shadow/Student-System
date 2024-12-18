package com.example.studentsystemapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {
    private Button enrollButton, summaryButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        enrollButton = findViewById(R.id.enrollButton);
        summaryButton = findViewById(R.id.summaryButton);
        logoutButton = findViewById(R.id.logoutButton);

        enrollButton.setOnClickListener(v -> startActivity(new Intent(this, EnrollActivity.class)));
        summaryButton.setOnClickListener(v -> startActivity(new Intent(this, SummaryActivity.class)));
        logoutButton.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
