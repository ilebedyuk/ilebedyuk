package org.mvvm.validators;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Constraint;

import static org.mvvm.validators.Validators.validateUsername;

/**
 * @author amakarov
 */
public class UserNameConstraint implements Constraint {
    @Override
    public void validate(Component component, Object o) throws WrongValueException {
        String name = (String) o;

        String msg = validateUsername(name);
        if (msg != null) {
            throw new WrongValueException(component, msg);
        }
    }
}
