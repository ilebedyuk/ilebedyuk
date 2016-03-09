package org.mvvm.viewModel;

import org.mvvm.Pojo.User;
import org.mvvm.services.UserService;
import org.mvvm.services.UserServiceSinglton;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import java.util.Map;

/**
 * @author amakarov
 */
public class UserInputViewModel {
    private User user;

    private UserService userService = UserServiceSinglton.getInstance();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Init
    public void init() {
        user = (User) ((Map) Executions.getCurrent().getArg()).get("user");
        if(user == null) {
            user = new User();
        }
    }
    @NotifyChange({"user"})
    @Command
    public void add(){
        userService.save(user.getName(), user.getPassword());
        user = new User();
    }
}
