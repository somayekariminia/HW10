package ir.maktab.service;

import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.User;
import ir.maktab.service.interfaces.shoppingBagService;

import java.util.ArrayList;

public class ShoppingBagImpl implements shoppingBagService {
    ArrayList<?extends Item> arrayList=new ArrayList<>();
    int capacity;
    boolean isConfirm;

    @Override
    public void addProductToShoppingBag(Item item, User user) {

    }

    @Override
    public void deleteProductOfShoppingBag(Item item, User user) {

    }

    @Override
    public ArrayList<? extends Item> printAllProductsShoppingBag(User user) {
        return null;
    }

    @Override
    public double printTotalPrice(User user) {
        return 0;
    }

    @Override
    public void isConfirmShoppingBag() {

    }
}
