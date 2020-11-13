package com.example.learning.implement.repsitory;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.learning.implement.model.Repo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReposRepository {

    private static final String TAG = "LOG_ME";
    private MutableLiveData<List<Repo>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Repo>> getMutableLiveData() {
        return mutableLiveData;
    }


    public void getRepositories() {
        RetrofitClient.getApiClient().getApi().getRepositories("alimemco").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Repo>> call, @NonNull Response<List<Repo>> response) {
                mutableLiveData.setValue(response.body());
                Log.i(TAG, "onResponse: "+response.code());
            }

            @Override
            public void onFailure(@NonNull Call<List<Repo>> call, @NonNull Throwable t) {
                Log.i(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
