package ir.maktab.service.interfaces;

import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface shoppingBagService {
    void addProductToShoppingBag(Item item, User user,int count) throws NotFoundException, SQLException;

    void deleteProductOfShoppingBag(Item item, User user) throws SQLException, NotFoundException;

    ArrayList<Item> printAllProductsShoppingBag(User user) throws SQLException, NotFoundException;
    double printTotalPrice(User user) throws SQLException, NotFoundException;
    void  isConfirmShoppingBag(User user) throws SQLException, NotFoundException;

}
