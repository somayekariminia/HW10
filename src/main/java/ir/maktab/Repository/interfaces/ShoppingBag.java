package ir.maktab.Repository.interfaces;

import ir.maktab.model.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingBag<T extends Item>{
    void addItemToShoppingBag(int userId,int itemId,int count,String type) throws SQLException;
    void deleteItemOfShoppingBag(int idUser,int idItem) throws SQLException;
   List<T> printAllItems(int idUser) throws SQLException;

}
