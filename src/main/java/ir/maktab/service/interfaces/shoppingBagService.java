package ir.maktab.service.interfaces;

import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface shoppingBagService {
    void addProductToShoppingBag(String typeItem,String codeItem,User user,int count) throws NotFoundException, SQLException;

    void deleteProductOfShoppingBag(String typeItem,String codeItem, User user) throws SQLException, NotFoundException;

    List<Item> printAllProductsShoppingBag(User user) throws SQLException, NotFoundException;
    double printTotalPrice(User user) throws SQLException, NotFoundException;
    boolean  isConfirmShoppingBag(User user) throws SQLException, NotFoundException;

}
