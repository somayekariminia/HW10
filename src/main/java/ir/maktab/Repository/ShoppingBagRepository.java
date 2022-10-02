package ir.maktab.Repository;

import java.util.List;

public class ShoppingBagRepository<T> implements ir.maktab.Repository.interfaces.ShoppingBag<T> {
    @Override
    public void addProductToBasket(Object product) {

    }

    @Override
    public void deleteProductOfBasket(Object product) {

    }

    @Override
    public List printProducts() {
        return null;
    }

    @Override
    public double printTotalPrice() {
        return 0;
    }
}
