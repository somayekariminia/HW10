package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.Repository.interfaces.ItemRepository;
import ir.maktab.model.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ItemRepositoryAbstract<T extends Item> implements ItemRepository<T> {

    @Override
    public void updateItems(int id, int count, T item) throws SQLException {
        Connection connection = GetConnection.getConnection();
        String string = "update" + " " + item.getItemType() + " " + " set countitem=? " + " " + " where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(string);
        preparedStatement.setInt(1, count);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<T> getProductsOfTable() throws SQLException {
        return null;
    }

    public int getIdByItem(T item) throws SQLException {
        Connection connection = GetConnection.getConnection();
        String str = "select *" + " " + " from " + item.getItemType() + " where nameItem=? and (codeItem=?)";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        preparedStatement.setString(1, item.getName());
        preparedStatement.setString(2,item.getCode());
        ResultSet resultSet = preparedStatement.executeQuery(item.getCode());
        while (resultSet.next()) {
         return resultSet.getInt("id");
        }
        return 0;
    }
}
