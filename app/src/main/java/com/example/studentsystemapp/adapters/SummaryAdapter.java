package com.example.studentsystemapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsystemapp.R;
import com.example.studentsystemapp.Models.Enrollment;

import java.util.List;

public class SummaryAdapter extends RecyclerView.Adapter<SummaryAdapter.SummaryViewHolder> {

    private List<Enrollment> enrollmentList;

    public SummaryAdapter(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    @NonNull
    @Override
    public SummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summary, parent, false);
        return new SummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SummaryViewHolder holder, int position) {
        Enrollment enrollment = enrollmentList.get(position);
        holder.courseNameTextView.setText("Course: " + enrollment.getCourseId());
        holder.semesterTextView.setText("Semester: " + enrollment.getSemester());
    }

    @Override
    public int getItemCount() {
        return enrollmentList.size();
    }

    static class SummaryViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTextView, semesterTextView;

        public SummaryViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            semesterTextView = itemView.findViewById(R.id.semesterTextView);
        }
    }
}
