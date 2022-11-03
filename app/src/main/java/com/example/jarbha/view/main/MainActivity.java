package com.example.jarbha.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jarbha.R;
import com.example.jarbha.databinding.ActivityMainBinding;
import com.example.jarbha.model.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //region Variables
    ActivityMainBinding binding;
    private CategoryAdapter categoryAdapter;
    private MainViewModel mainViewModel;
    //endregion

    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        categoryAdapter = new CategoryAdapter();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.getAllCategories().observe(this, new Observer<List<CategoryEntity>>() {
            @Override
            public void onChanged(List<CategoryEntity> categoryEntities) {
                categoryAdapter.updateList(categoryEntities);
            }
        });

        setupRecyclerView();
    }
    //endregion

    //region Methods
    private void setupRecyclerView() {
        categoryAdapter = new CategoryAdapter(new ArrayList<>());
        binding.activityMainRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.activityMainRecyclerView.setAdapter(categoryAdapter);
    }
    //endregion


}