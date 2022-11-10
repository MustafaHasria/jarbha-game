package com.example.jarbha.view.question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.jarbha.R;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Bundle bundle = getIntent().getExtras();
        Toast.makeText(this, "" + bundle.getString("NAME_CATEGORY"), Toast.LENGTH_SHORT).show();
    }
}