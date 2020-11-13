package com.example.learning.implement.repsitory;

import com.example.learning.implement.model.Repo;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

   @GET("users/{username}/repos")
   Call<List<Repo>> getRepositories(@Path("username") String username);


}
