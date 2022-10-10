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
            System.out.println("1: add\n2: delete\n3: print\n4: totalprice\n5: isconfirm\n6:back");
            System.out.println("enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    MenuProduct.menuProduct(user);
                    break;
                case 2:
                    try {
                        shoppingBag.printAllProductsShoppingBag(user);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                        ;
                    }
                    scanner.nextLine();
                    System.out.println("code product want delete");
                    String codeProduct1 = MenuProduct.inputCodeProduct();
                    System.out.println("typeProduct want delete");
                    String typeProduct1 = scanner.nextLine();
                    try {
                        shoppingBag.deleteProductOfShoppingBag(typeProduct1, codeProduct1, user);
                        System.out.println(" this product : " +codeProduct1+"deleted of your shopping bag");
                    } catch (SQLException | NotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    List<Item> list = new ArrayList<>();
                    try {
                        list = shoppingBag.printAllProductsShoppingBag(user);
                    } catch (SQLException | NotFoundException e) {
                        System.out.println(e.getMessage());;
                    }
                    printItems(list);
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
                            shoppingBag.isConfirmShoppingBag(user);
                            System.out.println("  your shopping register ");
                        } catch (SQLException e) {
                            System.err.println(e.getMessage());
                        } catch (NotFoundException e) {
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
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Device) {
                Device device = (Device) list.get(i);
                System.out.println(device.toString());
            }
            else if (list.get(i) instanceof Reading) {
                Reading reading = (Reading) list.get(i);
                System.out.println(reading.toString());
            }
            else if (list.get(i) instanceof Shoes) {
                Shoes shoes = (Shoes) list.get(i);
                System.out.println(shoes.toString());
            }
        }
    }
}
