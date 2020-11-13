package com.example.learning.mvvm.view.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.R;
import com.example.learning.databinding.ItemPerson;
import com.example.learning.mvvm.viewModel.PersonViewModel;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder> {

    private LayoutInflater layoutInflater;
    private List<PersonViewModel> models;

    public PersonAdapter(List<PersonViewModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());

        ItemPerson itemPerson = DataBindingUtil.inflate(layoutInflater, R.layout.item_person, parent, false);
        return new PersonHolder(itemPerson);
    }


    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
        holder.bind(models.get(position));
    }

    @Override
    public int getItemCount() {

        return models == null ? 0 : models.size();
    }

    public static class PersonHolder extends RecyclerView.ViewHolder {

        private final ItemPerson itemPerson;

        public PersonHolder(@NonNull ItemPerson itemPerson) {
            super(itemPerson.getRoot());
            this.itemPerson = itemPerson;
        }

        void bind(PersonViewModel personViewModel) {
            itemPerson.setPerson(personViewModel);
            itemPerson.executePendingBindings();
        }
    }
}
