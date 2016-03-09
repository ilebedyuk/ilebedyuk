package org.mvvm.viewModel;

import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

import java.util.Map;

/**
 * @author amakarov
 */
public class FormValidatorForAddUser extends AbstractValidator {
    @Override
    public void validate(ValidationContext ctx) {
        //all the bean properties
        Map<String,Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());

        validateName(ctx, (String) beanProps.get("name").getValue());
        validatePassword(ctx, (String) beanProps.get("password").getValue());
    }

    private void validatePassword(ValidationContext ctx, String password) {
        if (password == null || password.length() < 3) {
            this.addInvalidMessage(ctx, "password", "Your password should be > 3 characters!");
        }
    }

    private void validateName(ValidationContext ctx, String name) {
        if (name == null || name.length() < 3) {
            this.addInvalidMessage(ctx, "name", "Your name should be > 3 characters!");
        }
    }


}
