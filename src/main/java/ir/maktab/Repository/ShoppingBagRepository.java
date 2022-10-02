package ir.maktab.Repository;

        import ir.maktab.Repository.interfaces.ShoppingBag;
        import ir.maktab.model.entity.Item;

        import java.util.List;

public class ShoppingBagRepository<T extends Item> implements ShoppingBag<T> {

    @Override
    public void addItemToShoppingBag(T item) {

    }

    @Override
    public void deleteItemOfShoppingBag(T item) {

    }

    @Override
    public List printAllItems() {
        return null;
    }

    @Override
    public double printTotalPrice() {
        return 0;
    }
}
