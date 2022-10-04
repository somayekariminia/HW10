package ir.maktab.Repository.interfaces;

import ir.maktab.model.entity.Item;

import java.sql.SQLException;

public interface ItemRepository <T extends Item>{

    void updateItems(String name, String type, String color, int count)throws SQLException;
    int getId(String name, String type, String color, int size)  throws SQLException;
}
