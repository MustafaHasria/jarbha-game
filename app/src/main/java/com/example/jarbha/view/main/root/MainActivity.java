package com.example.jarbha.view.main.root;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.jarbha.R;
import com.example.jarbha.databinding.ActivityMainBinding;
import com.example.jarbha.view.main.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    //region Variables
    ActivityMainBinding binding;
    //endregion

    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        showFirstScreen();
        setContentView(binding.getRoot());
    }
    //endregion

    //region Methods
    void showFirstScreen(){

        HomeFragment homeFragment = new HomeFragment();

        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();

        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .add(R.id.activity_main_frame_layout_main_container, homeFragment, "HOME_FRAGMENT")
                .commit();
    }
    //endregion

}