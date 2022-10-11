package ir.maktab.view;

import ir.maktab.exeption.ValidationExeption;
import ir.maktab.model.entity.User;
import ir.maktab.service.DeviceServiceImpl;
import ir.maktab.service.ReadingServiceImpl;
import ir.maktab.service.ShoesServiceImpl;
import ir.maktab.service.UserServiceImpl;
import ir.maktab.util.ValidationInput;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuUser {
    private static UserServiceImpl userService = UserServiceImpl.getInstance();
    private static DeviceServiceImpl deviceService = DeviceServiceImpl.getInstance();
    private static ShoesServiceImpl shoesService = ShoesServiceImpl.getInstance();
    private static ReadingServiceImpl readingService = ReadingServiceImpl.getInstance();
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;
    public static void menuUser(){

        while (true) {
            System.out.println("1: register\n2: login\n3: exite");
            choice = inputMenu();
            switch (choice) {
                case 1 -> {
                    User user = enterUser();
                    try {
                        if (!userService.loginUser(user.getName(), user.getPassword())) {
                            MenuShoppingBag.menuShoppingBag(user);
                            menuThird(user);
                        } else {
                            menuThird(user);
                        }
                    } catch (SQLException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 2 -> {
                    User user1 = enterUser();
                    try {
                        if (userService.loginUser(user1.getName(), user1.getPassword())) {
                            menuThird(user1);
                        }
                    } catch (SQLException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 3 -> System.exit(1);
            }
        }
    }
    private static User enterUser() {
        String name = inputUserName();
        String password = inputPassword();
        return new User(name, password);
    }

    private static String inputUserName() {
        boolean answer = true;
        String name = null;
        while (answer) {
            System.out.println("enter name only letter [a-zA-Z]");
            try {
                name = ValidationInput.validationName(scanner.nextLine());
                answer = false;
            } catch (ValidationExeption e) {
                System.err.println(e.getMessage());
            }
        }
        return name;
    }

    private static String inputPassword() {
        boolean answer = true;
        String password = null;
        while (answer) {
            System.out.println("enter password only letter [a-zA-Z]*[0-9]*");
            try {
                password = ValidationInput.validationPassword(scanner.nextLine());
                answer = false;
            } catch (ValidationExeption e) {
                System.err.println(e.getMessage());
            }
        }
        return password;
    }
    private static int inputMenu(){
        boolean answer=true;
        int choice = 0;
        while(answer) {
            System.out.println("enter your choice  [1-9]");
            try {
                choice = ValidationInput.validationInputToMenu(scanner.nextLine());
                answer = false;
            } catch (ValidationExeption e) {
                System.err.println(e.getMessage());
            }
        }
        return choice;
    }

    private static void menuThird(User user) {
        while (true) {
            System.out.println("1: seeAllProducts\n2: shopping\n3: back");
            choice = inputMenu();
            switch (choice) {
                case 1 -> {
                    System.out.println("... Products Avalaible In Stores ...");
                    MenuProduct.printAllProducts();
                }
                case 2 -> {
                    System.out.println("... Shopping ...");
                    MenuShoppingBag.menuShoppingBag(user);
                }
                case 3 -> menuUser();
            }
        }
    }
}
