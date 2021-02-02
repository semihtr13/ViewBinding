package com.setsoft.training.viewbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.setsoft.training.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;
    private FragmentManager fragmentManager=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        fragmentManager=getSupportFragmentManager();
        setFragment(new HomeFragment());

        binding.btnHome.setOnClickListener(view1 -> {
            setFragment(new HomeFragment());
            binding.btnAbout.setBackgroundColor(Color.TRANSPARENT);
            binding.btnHome.setBackgroundResource(R.drawable.bg_main_menu_item);
        });

        binding.btnAbout.setOnClickListener(view1 -> {
            setFragment(new AboutFragment());
            binding.btnHome.setBackgroundColor(Color.TRANSPARENT);
            binding.btnAbout.setBackgroundResource(R.drawable.bg_main_menu_item);
        });


    }

    private void setFragment(Fragment fragment){

        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout,fragment)
                .commit();
    }
}