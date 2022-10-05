package ir.maktab.view;

import ir.maktab.Repository.CreateTable;
import ir.maktab.Repository.DeviceRepository;
import ir.maktab.Repository.ShoppingBagRepository;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Item;
import ir.maktab.model.enums.TypeProduct;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args)  {

        while(true)
        {  System.out.println("1: register\n2: login\n3: exite");
            System.out.println("enter your choice");
            int choice=scanner.nextInt();
           switch (choice){
               case 1:

               case 2:
               case 3:

            }

        }
    }
    public  static void menuFirst(){

    }
}
