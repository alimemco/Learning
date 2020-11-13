package com.example.learning.mvvm.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.learning.R;
import com.example.learning.databinding.ActivityLoginBinding;
import com.example.learning.mvvm.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_login);
        binding.setLoginViewModel(new LoginViewModel());
        binding.executePendingBindings();
    }

    @BindingAdapter("showMsg")
    public static void runMe(View view , String message){
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}