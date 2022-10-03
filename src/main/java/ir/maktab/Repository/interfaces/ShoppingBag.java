package ir.maktab.Repository.interfaces;

import ir.maktab.model.entity.Item;

import java.util.List;

public interface ShoppingBag<T extends Item<U>>{
    void addItemToShoppingBag(T item);
    void deleteItemOfShoppingBag(T item);
   List<T> printAllItems();
   double printTotalPrice();
}
