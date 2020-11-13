package com.example.learning.mvvm.viewModel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.mvvm.model.Person;
import com.example.learning.mvvm.view.adapters.PersonAdapter;

import java.util.ArrayList;
import java.util.List;

public class PersonViewModel extends BaseObservable {

    private MutableLiveData<List<PersonViewModel>> listMutableLiveData = new MutableLiveData<>();

    public Person person;

    public PersonViewModel(Person person) {
        this.person = person;
    }

    @Bindable
    public Person getPerson() {
        return person;
    }

    public PersonViewModel() {

        List<PersonViewModel> personViewModels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            personViewModels.add(new PersonViewModel(new Person("name #"+i)));
        }
        listMutableLiveData.setValue(personViewModels);

    }

    public MutableLiveData<List<PersonViewModel>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public void setListMutableLiveData(MutableLiveData<List<PersonViewModel>> listMutableLiveData) {
        this.listMutableLiveData = listMutableLiveData;
    }


    @BindingAdapter("setAdapter")
    public static void setAdapter(RecyclerView recyclerView , MutableLiveData<List<PersonViewModel>> listMutableLiveData){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        listMutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), personViewModels -> {
            recyclerView.setAdapter(new PersonAdapter(personViewModels));
        });


    }
}
