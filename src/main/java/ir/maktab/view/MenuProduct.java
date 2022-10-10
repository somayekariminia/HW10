package ir.maktab.view;

import ir.maktab.exeption.NotFoundException;
import ir.maktab.exeption.ValidationExeption;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Reading;
import ir.maktab.model.entity.Shoes;
import ir.maktab.model.entity.User;
import ir.maktab.service.*;
import ir.maktab.util.ValidationInput;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuProduct {
    private static UserServiceImpl userService = UserServiceImpl.getInstance();
    private static DeviceServiceImpl deviceService = DeviceServiceImpl.getInstance();
    private static ShoesServiceImpl shoesService = ShoesServiceImpl.getInstance();
    private static ReadingServiceImpl readingService = ReadingServiceImpl.getInstance();
    private  static ShoppingBagImpl shoppingBag=ShoppingBagImpl.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void menuProduct(User user) {
        while (true) {
            System.out.println("1: device\n2: reading\n3: shoes\n4: add Shopping\n5:back");
            System.out.println(" enter your choice ");
            int choice = inputCount();
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
                case 4->{
                    scanner.nextLine();
                    String codeProduct = inputCodeProduct();
                    System.out.println("typeProduct");
                    String typeProduct = scanner.nextLine();
                    System.err.println("How many Are you want Product?");
                    int count = inputCount();
                    try {
                        shoppingBag.addProductToShoppingBag(typeProduct,codeProduct,user,count);
                    } catch (NotFoundException | SQLException e) {
                        System.out.println(e.getMessage());;
                    }
                }
                case 5->{
                    MenuShoppingBag.menuShoppingBag(user);
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
        } catch (SQLException | NotFoundException e) {
            System.err.println();;
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
    public static void printAllProducts() {
        printDevices();
        printReadings();
        printShoes();
    }
   public static String inputCodeProduct(){
        boolean answer=true;
        String codeProduct = null;
        while (answer){
            System.out.println("code product");
            try {
                codeProduct = ValidationInput.validationCodeProduct(scanner.nextLine());
                answer=false;
            } catch (ValidationExeption e) {
                System.err.println(e.getMessage());
            }
        }
        return codeProduct;
    }
  public static int inputCount(){
        int count=0;
        boolean answer=true;
        while(answer){
            try {
                count = ValidationInput.validationInputToMenu(scanner.nextLine());
                answer=false;
            } catch (ValidationExeption e) {
                System.out.println(e.getMessage());
            }
        }
        return  count;
    }
}
