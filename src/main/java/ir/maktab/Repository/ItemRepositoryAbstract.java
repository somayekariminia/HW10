package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.Repository.interfaces.ItemRepository;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Item;
import ir.maktab.model.enums.TypeProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public int getId(String name, String type, String color, int size) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from item where nameItem=? and " +
                " typeItem=? and color=? and sizeItem=? ");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, type);
        preparedStatement.setString(3, color);
        preparedStatement.setInt(4, size);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("id");
        }
        return 0;
    }

    public int getIdByItem(Item item) throws SQLException {
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
