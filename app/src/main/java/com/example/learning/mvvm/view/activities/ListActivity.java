package com.example.learning.mvvm.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.learning.R;
import com.example.learning.databinding.ActivityListBinding;
import com.example.learning.mvvm.viewModel.PersonViewModel;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActivityListBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_list);
        binding.setPersonBinding(new PersonViewModel());
        binding.executePendingBindings();
    }
}