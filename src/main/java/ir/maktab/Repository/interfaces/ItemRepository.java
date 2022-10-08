package ir.maktab.Repository.interfaces;

import ir.maktab.model.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemRepository <T extends Item>{

    void updateItems(int id,int count,T item)throws SQLException;
     List<T> getProductsOfTable() throws SQLException;
     int getIdByItem(String typeProduct,String codeProduct) throws SQLException;
}
