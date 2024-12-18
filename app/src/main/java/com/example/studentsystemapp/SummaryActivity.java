package com.example.studentsystemapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsystemapp.Models.Enrollment;
import com.example.studentsystemapp.adapters.SummaryAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class SummaryActivity extends AppCompatActivity {
    private RecyclerView summaryRecyclerView;
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        summaryRecyclerView = findViewById(R.id.summaryRecyclerView);
        backButton = findViewById(R.id.backButton);
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        loadEnrollments();

        backButton.setOnClickListener(v -> finish());
    }

    private void loadEnrollments() {
        String userId = auth.getCurrentUser().getUid();
        db.collection("Enrollments").whereEqualTo("userId", userId).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Enrollment> enrollmentList = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Enrollment enrollment = document.toObject(Enrollment.class);
                            enrollmentList.add(enrollment);
                        }
                        SummaryAdapter adapter = new SummaryAdapter(enrollmentList);
                        summaryRecyclerView.setAdapter(adapter);
                    }
                });
    }
}
