package ir.maktab.util;

import ir.maktab.exeption.ValidationExeption;

public class ValidationInput {
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
    public static  int validationInputToMenu(String input) throws ValidationExeption {
    if(input.matches("[1-9]"))
        return Integer.parseInt(input);
    else
        throw  new ValidationExeption("please enter a number");
    }
    public static  String validationCodeProduct(String input) throws ValidationExeption {
        if(input.matches("[1-9]{3,}[a-z]*"))
            return input;
        else
            throw new ValidationExeption("codeProduct is not valid");

    }

}
