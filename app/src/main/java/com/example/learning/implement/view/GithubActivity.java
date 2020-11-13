package com.example.learning.implement.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.learning.R;
import com.example.learning.databinding.ActivityGithubBinding;
import com.example.learning.implement.viewModel.GithubViewModel;

public class GithubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        ActivityGithubBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_github);
        binding.setViewModelGithub(new GithubViewModel(this));
        binding.executePendingBindings();
    }
}