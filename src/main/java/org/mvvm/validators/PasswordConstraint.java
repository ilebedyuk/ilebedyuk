package org.mvvm.validators;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Constraint;

import static org.mvvm.validators.Validators.validatePassword;

/**
 * @author amakarov
 */
public class PasswordConstraint implements Constraint{

    @Override
    public void validate(Component component, Object o) throws WrongValueException {
        String password = (String) o;

        String msg = validatePassword(password);
        if (msg != null) {
            throw new WrongValueException(component, msg);
        }
    }
}

