package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.Repository.interfaces.ItemRepository;
import ir.maktab.model.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ItemRepositoryAbstract<T extends Item> implements ItemRepository<T> {

    public void addItem(Item item) {
    }

    @Override
    public void updateItems(String name, String type, String color, int count) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update item set count=? " +
                " where nameItem=? and typeItem=? and color=?");
        preparedStatement.setInt(1, count);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, type);
        preparedStatement.setString(4, color);
        preparedStatement.executeUpdate();
    }

    @Override
    public double getPrice(String name, String type, String color, int size) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from item where nameItem=? and " +
                " typeItem=? and color=? and sizeItem=? ");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,type);
        preparedStatement.setString(3,color);
        preparedStatement.setInt(4,size);
        ResultSet resultSet =preparedStatement.executeQuery();
        while (resultSet.next())
        {
            return resultSet.getDouble("price");
        }
        return 0;
    }

    @Override
    public int getId(String name, String type, String color, int size) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from item where nameItem=? and " +
                " typeItem=? and color=? and sizeItem=? ");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,type);
        preparedStatement.setString(3,color);
        preparedStatement.setInt(4,size);
        ResultSet resultSet =preparedStatement.executeQuery();
        while (resultSet.next())
        {
            return resultSet.getInt("id");
        }
        return 0;
    }
}
