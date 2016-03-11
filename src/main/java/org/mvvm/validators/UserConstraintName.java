package org.mvvm.validators;

import org.mvvm.services.UserService;
import org.mvvm.services.UserServiceSinglton;
import org.mvvm.services.ValidationService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Constraint;

/**
 * @author amakarov
 */
public class UserConstraintName implements Constraint {

    private UserService userService = UserServiceSinglton.getInstance();
    private ValidationService validationService = new ValidationService(userService);

    @Override
    public void validate(Component component, Object o) throws WrongValueException {
        String login = (String) o;
        String password = "test";
//        String password = (String) o;
        String msg = "No such user";
        if (validationService.isUser(login, password) != true) {
            throw new WrongValueException(component, msg);
        }
    }
}
