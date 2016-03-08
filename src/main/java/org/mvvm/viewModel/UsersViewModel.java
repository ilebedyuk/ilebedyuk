package org.mvvm.viewModel;

import org.mvvm.Pojo.User;
import org.mvvm.dao.lists.UserDaoImpl;
import org.mvvm.services.UserService;
import org.zkoss.bind.annotation.Init;

import java.util.List;

/**
 * @author amakarov
 */
public class UsersViewModel {
    private List<User> users;
    private User selectedUser;

    private UserService userService = new UserService(new UserDaoImpl());

    public UsersViewModel(UserService userService) {
        this.userService = userService;
    }

    public UsersViewModel() {
    }

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


//    @Command
//    @NotifyChange("users")
//    public void showUsers() {
//        users = userService.findAll();
//    }
}
