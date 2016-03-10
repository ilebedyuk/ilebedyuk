package org.mvvm.validators;

import java.util.regex.Pattern;

/**
 * @author amakarov
 */
public class Validators {
    public static final String USERNAME_PATTERN = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

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

    public static String validatePassword(final String password) {
        if(password == null || password.isEmpty() || password.trim().isEmpty()) {
            return "Empty password";
        }
//        if (!Pattern.compile(PASSWORD_PATTERN).matcher(password).matches()) {
//            if(!Pattern.compile("(?=.*\\d)").matcher(password).matches()) {
//                return "Incorrect password (must contains one digit from 0-9)";
//            } else if(!Pattern.compile("(?=.*[a-z])").matcher(password).matches()) {
//                return "Incorrect password (must contains one lowercase characters)";
//            } else if(!Pattern.compile("(?=.*[A-Z])").matcher(password).matches()) {
//                return "Incorrect password (must contains one uppercase characters)";
//            } else if(!Pattern.compile("(?=.*[@#$%])").matcher(password).matches()) {
//                return "Incorrect password (must contains one special symbols in the list '@#$%')";
//            } else {
//                return  "Incorrect password (length at least 6 characters and maximum of 20";
//            }
//        }
        // success
        return null;
    }
}
