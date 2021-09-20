package com.example.navigationdrawer.ui.verde;

import androidx.lifecycle.ViewModel;

import com.example.navigationdrawer.UserAlmi;

import java.util.ArrayList;
import java.util.List;

public class VerdeViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private List<UserAlmi> userAlmiList;

    public VerdeViewModel() {
        userAlmiList = new ArrayList<>();
    }

    private VerdeViewModel(List<UserAlmi> userAlmiList){
        this.userAlmiList = userAlmiList;
    }

    public void addUser(UserAlmi userAlmi){
        userAlmiList.add(userAlmi);
    }

    public List<UserAlmi> getUserList(){
        return this.userAlmiList;
    }

    public void setUserList (List<UserAlmi> userAlmiList){
        this.userAlmiList = userAlmiList;
    }
}