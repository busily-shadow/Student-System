package com.example.studentsystemapp.Models;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studentsystemapp.R;

public class Course {
    private String courseName;
    private int credits;

    public Course() {}

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }
}
