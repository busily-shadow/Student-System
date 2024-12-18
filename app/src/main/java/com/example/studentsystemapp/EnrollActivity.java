package com.example.studentsystemapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsystemapp.adapters.CoursesAdapter;
import com.example.studentsystemapp.Models.Course;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class EnrollActivity extends AppCompatActivity {
    private RecyclerView coursesRecyclerView;
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);


        coursesRecyclerView = findViewById(R.id.coursesRecyclerView);
        backButton = findViewById(R.id.backButton);


        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        coursesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadCourses();

        backButton.setOnClickListener(v -> finish());
    }

    private void loadCourses() {
        db.collection("Courses").get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Course> courseList = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Course course = document.toObject(Course.class);
                            courseList.add(course);
                        }

                        CoursesAdapter adapter = new CoursesAdapter(courseList);
                        coursesRecyclerView.setAdapter(adapter);
                    } else {

                        task.getException().printStackTrace();
                    }
                });
    }
}

