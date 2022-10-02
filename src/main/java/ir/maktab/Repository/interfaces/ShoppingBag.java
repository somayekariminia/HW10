package ir.maktab.Repository.interfaces;

import java.util.List;

public interface ShoppingBag<T>{
    void addProductToBasket(T product);
    void deleteProductOfBasket(T product);
   List<T> printProducts();
   double printTotalPrice();
}
