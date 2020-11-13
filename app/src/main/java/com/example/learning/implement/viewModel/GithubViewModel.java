package com.example.learning.implement.viewModel;

import android.content.Context;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.implement.model.Repo;
import com.example.learning.implement.repsitory.ReposRepository;
import com.example.learning.implement.view.GithubAdapter;

import java.util.ArrayList;
import java.util.List;

public class GithubViewModel extends BaseObservable {

    private static final String TAG = "LOG_ME";
    private Repo repo;
    private MutableLiveData<List<GithubViewModel>> mutableLiveData = new MutableLiveData<>();

    public GithubViewModel(Repo repo) {
        this.repo = repo;
    }

    @Bindable
    public Repo getRepo() {
        return repo;
    }


    private Context context;

    public GithubViewModel(Context context) {
        this.context = context;

/*        List<GithubViewModel> models = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            models.add(new GithubViewModel(new Repo("repository #" + i)));
        }

        mutableLiveData.setValue(models);    */


        ReposRepository repository = new ReposRepository();

        Log.i(TAG, "repository: ");
        repository.getMutableLiveData().observe((LifecycleOwner) context, repos -> {
            List<GithubViewModel> models = new ArrayList<>();
            for (int i = 0; i < repos.size(); i++) {
                models.add(new GithubViewModel(repos.get(i)));
            }

            mutableLiveData.setValue(models);
        });

        repository.getRepositories();

    }

    public MutableLiveData<List<GithubViewModel>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(MutableLiveData<List<GithubViewModel>> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }

    @BindingAdapter("setModels")
    public static void setModels(RecyclerView recyclerView, MutableLiveData<List<GithubViewModel>> mutableLiveData) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        mutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), githubViewModels -> {
            recyclerView.setAdapter(new GithubAdapter(githubViewModels));
        });
    }


}
