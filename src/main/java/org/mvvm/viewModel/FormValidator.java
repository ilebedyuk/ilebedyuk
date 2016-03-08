package org.mvvm.viewModel;

import org.mvvm.dao.lists.UserDaoImpl;
import org.mvvm.services.UserService;
import org.mvvm.services.ValidationService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

/**
 * @author amakarov
 */
public class FormValidator {
    private UserService userService = new UserService(new UserDaoImpl());
    private ValidationService validationService = new ValidationService(userService);

    private String login;
    private String password;

    public FormValidator(ValidationService validationService) {
        this.validationService = validationService;
    }

    public FormValidator() {}

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ValidationService getValidationService() {
        return validationService;
    }

    public void setValidationService(ValidationService validationService) {
        this.validationService = validationService;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Command
    public void login() {
        if (validationService.isUser(login, password)) {
            Executions.sendRedirect("/parts/main.zul");
        } else {
            Executions.sendRedirect("/index.zul");
        }
    }
}
