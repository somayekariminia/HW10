package ir.maktab.Repository.interfaces;

public interface Store<U> {
    void addProductToStore(U entity);
    void updateStockStore();
}
