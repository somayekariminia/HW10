package ir.maktab.Repository.interfaces;

import ir.maktab.model.entity.Item;

import java.sql.SQLException;

public interface ItemRepository <T extends Item>{
    void addItem(T item) throws SQLException;
    void updateItems(String name, String type, String color, int count)throws SQLException;
    double getPrice(String name, String type, String color, int size) throws SQLException;
    int getId(String name, String type, String color, int size)  throws SQLException;
}
