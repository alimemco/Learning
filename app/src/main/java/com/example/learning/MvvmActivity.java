package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.learning.mvvm.view.activities.ListActivity;
import com.example.learning.mvvm.view.activities.LoginActivity;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);

        findViewById(R.id.button_activityMvvm_login)
                .setOnClickListener(view -> {
                    startActivity(new Intent(this , LoginActivity.class));
                });


        findViewById(R.id.button_activityMvvm_list)
                .setOnClickListener(view -> {
                    startActivity(new Intent(this , ListActivity.class));
                });
    }
}