package ir.maktab.view;

import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.*;
import ir.maktab.service.ShoppingBagImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuShoppingBag {
    private static Scanner scanner = new Scanner(System.in);
    private static ShoppingBagImpl shoppingBag = ShoppingBagImpl.getInstance();

    public static void menuShoppingBag(User user) {
        while(true) {
            System.out.println("1: add\n2: delete\n3: print\n4: totalprice\n5: isconfirm\n6: back To Menu First");
            System.out.println("enter your choice");
            int choice = MenuProduct.inputCount();
            switch (choice) {
                case 1:
                    MenuProduct.menuProduct(user);
                    break;
                case 2:
                    List<Item> list = new ArrayList<>();
                    try {
                        list = shoppingBag.printAllProductsShoppingBag(user);
                    } catch (SQLException | NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    printItems(list);

                    scanner.nextLine();
                    System.out.println("code product want delete");
                    String codeProduct1 = MenuProduct.inputCodeProduct();
                    System.out.println("typeProduct want delete");
                    String typeProduct1 = scanner.nextLine();
                    try {
                        shoppingBag.deleteProductOfShoppingBag(typeProduct1, codeProduct1, user);
                        System.out.println(" this product : " + codeProduct1 + " " + "Deleted of your ShoppingCard");
                    } catch (SQLException | NotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    List<Item> list1 = new ArrayList<>();
                    try {
                        list1 = shoppingBag.printAllProductsShoppingBag(user);
                    } catch (SQLException | NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    printItems(list1);
                    break;
                case 4:
                    try {
                        System.out.println(shoppingBag.printTotalPrice(user));
                    } catch (SQLException | NotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("are you isConfirm your shopping");
                    String answer=scanner.nextLine();
                    if(answer.equals("yes")) {
                        try {
                            if (shoppingBag.isConfirmShoppingBag(user))
                                System.out.println("  your shopping register ");
                            else
                                System.out.println("your shopping doesnot Isconfirm");

                        } catch (SQLException | NotFoundException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    else
                        System.out.println("is not register yourShopping");
                    break;
                case 6:
                   MenuUser.menuUser();
            }
        }
    }
    private static void printItems(List<Item> list) {
        for (Item item : list) {
            if (item instanceof Device) {
                Device device = (Device) item;
                System.out.println(device);
            } else if (item instanceof Reading) {
                Reading reading = (Reading) item;
                System.out.println(reading);
            } else if (item instanceof Shoes) {
                Shoes shoes = (Shoes) item;
                System.out.println(shoes);
            }
        }
    }
}
