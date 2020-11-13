package com.example.learning.mvvm.viewModel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.learning.BR;
import com.example.learning.mvvm.model.User;

public class LoginViewModel  extends BaseObservable {

    User user ;

    private String toastMessage;
    private final String successMessage = "Login was successful";
    private final String errorMessage = "Email or Password not valid";

    public LoginViewModel() {
        this.user = new User("","");
    }

    @Bindable
    public String getUserPassword(){
        return user.getPassword();
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getToastMessage() {
        return toastMessage;
    }

    public void setUserPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    @Bindable
    public String getUserEmail(){
        return user.getEmail();
    }

    public void setUserEmail(String email){
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    public void onLoginClicked(){
        if (isInputDataValid()){
            setToastMessage(successMessage);
        }else {
            setToastMessage(errorMessage);
        }
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}
