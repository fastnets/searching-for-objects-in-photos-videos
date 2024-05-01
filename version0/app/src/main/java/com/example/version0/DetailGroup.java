package com.example.version0;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.version0.databinding.ActivityDetailGroupBinding;

public class DetailGroup extends AppCompatActivity {

    ActivityDetailGroupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailGroupBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String number = intent.getStringExtra("0");
            int students = intent.getIntExtra("students", R.string.groupStudents1);

            binding.detailName.setText(name);
            binding.detailNumber.setText(number);
            binding.detailStudentsNames.setText(students);
        }
    }
}