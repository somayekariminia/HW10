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

public class Main {


    public static void main(String[] args) throws SQLException {
        ShoppingBagRepository shoppingBagRepository=new ShoppingBagRepository();
        List<Item> list=new ArrayList<>();
        list=shoppingBagRepository.selectAllItems(1);
    }
}
