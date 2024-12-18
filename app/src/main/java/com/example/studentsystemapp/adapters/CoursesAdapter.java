package com.example.studentsystemapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsystemapp.R;
import com.example.studentsystemapp.Models.Course;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CourseViewHolder> {

    private List<Course> courseList;

    public CoursesAdapter(List<Course> courseList) {
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courseList.get(position);
        holder.courseNameTextView.setText(course.getCourseName());
        holder.creditsTextView.setText("Credits: " + course.getCredits());

        holder.enrollButton.setOnClickListener(v -> enrollInCourse(course));
    }

    private void enrollInCourse(Course course) {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Add enrollment data
        Map<String, Object> enrollmentData = new HashMap<>();
        enrollmentData.put("userId", userId);
        enrollmentData.put("courseId", course.getCourseName());
        enrollmentData.put("semester", "Fall 2024");

        db.collection("Enrollments").add(enrollmentData)
                .addOnSuccessListener(documentReference -> {
                    // Enrollment successful
                })
                .addOnFailureListener(e -> {
                    // Handle failure
                });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTextView, creditsTextView;
        Button enrollButton;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            creditsTextView = itemView.findViewById(R.id.creditsTextView);
            enrollButton = itemView.findViewById(R.id.enrollButton);
        }
    }
}
