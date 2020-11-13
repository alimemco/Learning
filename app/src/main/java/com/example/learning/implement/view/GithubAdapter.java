package com.example.learning.implement.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.R;
import com.example.learning.databinding.ItemRepositoryBinding;
import com.example.learning.implement.viewModel.GithubViewModel;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubHolder> {

    private LayoutInflater inflater;
    private List<GithubViewModel> models;

    public GithubAdapter(List<GithubViewModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public GithubHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.getContext());

        ItemRepositoryBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_github_repository, parent, false);

        return new GithubHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubHolder holder, int position) {
        holder.bind(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models == null ? 0 : models.size();
    }

    public static class GithubHolder extends RecyclerView.ViewHolder {

        private final ItemRepositoryBinding binding;

        public GithubHolder(@NonNull ItemRepositoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(GithubViewModel githubViewModel) {
            binding.setViewModelGithub(githubViewModel);
            binding.executePendingBindings();
        }
    }
}
