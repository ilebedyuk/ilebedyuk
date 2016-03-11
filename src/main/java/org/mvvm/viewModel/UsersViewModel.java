package org.mvvm.viewModel;

import org.mvvm.Pojo.User;
import org.mvvm.services.UserService;
import org.mvvm.services.UserServiceSinglton;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

import java.util.HashMap;
import java.util.List;

/**
 * @author amakarov
 */
public class UsersViewModel {
    private List<User> users;
    private User selectedUser;
    private Window window;

    private UserService userService = UserServiceSinglton.getInstance();

//    //public UsersViewModel(UserService userService) {
//        this.userService = userService;
//    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UsersViewModel() {}

    public List<User> getUsers() {
        return users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    @Init
    public void loadUsers() {
        users = userService.findAllUsers();
    }

    @Command
    public void showAddUser() {
        window = (Window) Executions.createComponents("/modalWindow/userInputForm.zul", null, null);
        window.setTitle("Adding User");
        window.doModal();
    }

    @NotifyChange({"selectedUser"})
    @Command
    public void removeUser(){
        if(selectedUser != null) {
            userService.remove(selectedUser);
            selectedUser = null;
        }
    }

    @Command
    public void showEditUser(){
        if (selectedUser != null){
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("user", selectedUser);
            window = (Window) Executions.createComponents("/modalWindow/userInputForm.zul", null, params);
            window.setTitle("Editing User");
            window.doModal();
        }
    }

    @GlobalCommand
    public void closeWindow() {
        if(window != null) {
            window.onClose();
            window = null;
        }
    }

    @NotifyChange({"users"})
    @GlobalCommand
    public void refresh() {
        users = userService.findAllUsers();
    }

}
