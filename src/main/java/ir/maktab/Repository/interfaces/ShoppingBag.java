package ir.maktab.Repository.interfaces;

import ir.maktab.model.entity.Item;

import java.util.List;

public interface ShoppingBag<T extends Item>{
    void addProductToBasket(T item);
    void deleteProductOfBasket(T item);
   List<T> printProducts();
   double printTotalPrice();
}
