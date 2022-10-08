package ir.maktab.service.interfaces;

import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemService<T extends Item> {
    void updateStockItems(T item,int count) throws SQLException;
    List<T>printAllItemsTables() throws SQLException, NotFoundException;
    int getIdItem(String typeProduct,String codeProduct) throws SQLException;
}
