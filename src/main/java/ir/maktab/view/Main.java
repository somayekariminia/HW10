package ir.maktab.view;

import ir.maktab.exeption.NotFoundException;
import ir.maktab.exeption.ValidationExeption;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Reading;
import ir.maktab.model.entity.Shoes;
import ir.maktab.model.entity.User;
import ir.maktab.service.DeviceServiceImpl;
import ir.maktab.service.ReadingServiceImpl;
import ir.maktab.service.ShoesServiceImpl;
import ir.maktab.service.UserServiceImpl;
import ir.maktab.util.ValidationNameUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UserServiceImpl userService = UserServiceImpl.getInstance();
    private static DeviceServiceImpl deviceService = DeviceServiceImpl.getInstance();
    private static ShoesServiceImpl shoesService = ShoesServiceImpl.getInstance();
    private static ReadingServiceImpl readingService = ReadingServiceImpl.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("1: register\n2: login\n3:exite");
            System.out.println("enter your choice");
            int choice = Integer.valueOf(scanner.nextInt());
            switch (choice) {
                case 1:
                    User user = enterUser();
                    try {
                        if (!userService.loginUser(user.getName(), user.getPassword())) {
                            userService.registerUser(user);
                            menueShopping(user);
                        } else {
                            menueShopping(user);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    User user1 = enterUser();
                    try {
                        if (userService.loginUser(user1.getName(), user1.getPassword()))
                        {
                            menueShopping(user1);
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.exit(1);
            }
        }
    }
    private static void menueShopping(User user) {
        while(true) {
            System.out.println("1: View All Products\n2: shoppingBag\n3: exite");
            System.out.println(" enter your choice");
            int answer = Integer.valueOf(scanner.nextLine());
            switch (answer) {
                case 1:
                    System.out.println(" View All Prodects ");
                    System.out.println("-----------------------------------");
                    System.out.println("                     ");
                    printDevices();
                    printReadings();
                    printShoes();
                    break;
                case 2:
                    System.out.println(" ShoppingBag ");
                    menuProduct(user);
                    break;
                case 3:
                    System.exit(1);
            }
        }
    }

    public static void menuProduct(User user) {
        while (true) {
            System.out.println("1: device\n2: reading\n3: shoes\n4:ShoppingBag\n5:exite");
            System.out.println(" enter your choice ");
            int choice = Integer.valueOf(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    printDevices();
                }
                case 2 -> {
                    printReadings();
                }
                case 3 -> {
                    printShoes();
                }
                case 4 -> {
                    System.out.println(">>>> ShoppingBag <<<<");
                    MenuShoppingBag.menuShoppingBag(user);}
                    case 5->{
                        System.exit(1);
                    }
                }
            }
        }


    private static void printReadings() {
        List<Reading> arrayList = new ArrayList<>();
        try {
            arrayList = readingService.printAllItemsTables();
            for (Reading reading : arrayList) {
                System.out.println(reading.print());
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printShoes() {
        List<Shoes> arrayList = new ArrayList<>();
        try {
            arrayList = shoesService.printAllItemsTables();
            for (Shoes shoes : arrayList) {
                System.out.println(shoes.print());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            ;
        } catch (NotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printDevices() {
        List<Device> arrayList = new ArrayList<>();
        try {
            arrayList = deviceService.printAllItemsTables();
            for (Device device : arrayList) {
                System.out.println(device.print());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (NotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static User enterUser() {
        scanner.nextLine();
        System.out.println("enter name only letter [a-zA-Z]");
        String name = null;
        try {
            name = ValidationNameUser.validationName(scanner.nextLine());
        } catch (ValidationExeption e) {
            System.err.println(e.getMessage());
            ;
        }
        System.out.println("enter password only [a-zA-Z]*[0-9]* example som31200");
        String password = null;
        try {
            password = ValidationNameUser.validationPassword(scanner.nextLine());
        } catch (ValidationExeption e) {
            System.err.println(e.getMessage());
            ;
        }
        return new User(name, password);
    }
}
