package org.mvvm.validators;

import java.util.regex.Pattern;

/**
 * @author amakarov
 */
public class Validators {
    public static final String USERNAME_PATTERN = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";

    private Validators() {}

    public static String validateUsername(final String username) {
        if(username == null || username.isEmpty() || username.trim().isEmpty()) {
            return "Empty username";
        }
        if (!Pattern.compile(USERNAME_PATTERN).matcher(username).matches()) {
            if(Pattern.compile("^[_.].*").matcher(username).matches()) {
                return "Incorrect username (shouldn't be _ or . at the beginning)";
            } else if(Pattern.compile(".*[_.]{2}.*").matcher(username).matches()) {
                return "Incorrect username (shouldn't be __ or _. or ._ or .. inside)";
            } else if(Pattern.compile(".*[_.]$").matcher(username).matches()) {
                return "Incorrect username (shouldn't be _ or . at the end)";
            } else if(!Pattern.compile("[a-zA-Z0-9._]{8,20}$").matcher(username).matches()) {
                return "Incorrect username (username is 8-20 characters long)";
            } else {
                return  "Incorrect username";
            }
        }
        // success
        return null;
    }
}
