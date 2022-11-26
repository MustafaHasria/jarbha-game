package com.example.jarbha.view.main.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jarbha.R;
import com.example.jarbha.databinding.FragmentHomeBinding;
import com.example.jarbha.model.entity.CategoryEntity;
import com.example.jarbha.view.main.question.QuestionsFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements CategoryAdapter.CategoryAdapterClickListeners {

    //region Variables
    private CategoryAdapter categoryAdapter;
    private HomeViewModel mainViewModel;
    private FragmentHomeBinding binding;
    //endregion

    //region Life cycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(view);


        mainViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        setupRecyclerView();

        mainViewModel.getAllCategories().observe(requireActivity(), new Observer<List<CategoryEntity>>() {
            @Override
            public void onChanged(List<CategoryEntity> categoryEntities) {
                categoryAdapter.updateList(categoryEntities);
            }
        });

        return binding.getRoot();
    }
    //endregion


    //region Methods
    private void setupRecyclerView() {
        categoryAdapter = new CategoryAdapter(new ArrayList<>(),this);
        binding.activityMainRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.activityMainRecyclerView.setAdapter(categoryAdapter);
    }

    //endregion


    //region Adapter click listener

    @Override
    public void onItemRecyclerViewCategoryCardViewMainContainerClickListener(int position, CategoryEntity categoryEntity) {
        Bundle bundle = new Bundle();
        bundle.putString("NAME_CATEGORY", categoryEntity.getName());
        QuestionsFragment questionsFragment = new QuestionsFragment();

        FragmentTransaction fragmentTransaction =
                requireActivity().getSupportFragmentManager().beginTransaction();

        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out)
                .replace(R.id.activity_main_frame_layout_main_container, questionsFragment, "QUESTIONS_FRAGMENT")
                .addToBackStack("HOME_FRAGMENT")
                .commit();
//        Intent intent = new Intent(this, QuestionsActivity.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
    }
    //endregion
}