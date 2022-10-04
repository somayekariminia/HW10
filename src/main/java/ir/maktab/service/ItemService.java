package ir.maktab.service;

import ir.maktab.model.entity.Item;

import java.sql.SQLException;

public interface ItemService<T extends Item> {
    void updateStockItems(T item,int count) throws SQLException;
    int getIdItem(T item) throws SQLException;
}
