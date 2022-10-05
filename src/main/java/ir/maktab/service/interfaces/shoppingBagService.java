package ir.maktab.service.interfaces;

import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.User;

import java.util.ArrayList;

public interface shoppingBagService {
    void addProductToShoppingBag(Item item, User user);

    void deleteProductOfShoppingBag(Item item, User user);

    ArrayList<? extends Item> printAllProductsShoppingBag(User user);
    double printTotalPrice(User user);
    void  isConfirmShoppingBag();

}
