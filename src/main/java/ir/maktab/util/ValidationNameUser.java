package ir.maktab.util;

import ir.maktab.exeption.ValidationExeption;

public class ValidationNameUser {
    public static String validationName(String name) throws ValidationExeption {
        if (name.matches("[a-zA-Z]*"))
            return name;
        else
            throw new ValidationExeption("name is not valid");
    }

    public static String validationPassword(String password) throws ValidationExeption {
        if (password.matches("[a-z]*[0-9]*"))
            return password;
        else
            throw new ValidationExeption("password is not valid");


    }

}
