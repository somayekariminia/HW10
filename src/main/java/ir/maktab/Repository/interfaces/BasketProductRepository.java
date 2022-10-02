package ir.maktab.Repository.interfaces;

import java.util.List;

public class BasketProductRepository<T> implements BasketProduct<T> {
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
