package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Shoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoesRepository<T extends Shoes> {
    public void addDevice(T item) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into shoes(nameshoes,typeshoes,color,count,price,sizeshoes) values (?,?,?,?,?,?)");
        preparedStatement.setString(1, item.getName());
        preparedStatement.setString(2, String.valueOf(item.getShoesType()));
        preparedStatement.setString(3, item.getColor());
        preparedStatement.setInt(4, item.getCount());
        preparedStatement.setDouble(5, item.getPrice());
        preparedStatement.setInt(6, item.getSize());
        preparedStatement.executeUpdate();
    }

    public void UpdateDevice(T item, int count) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update shoes set count=? " +
                " where nameDevice=? and typeDevice=? and sizeshoes=? ");
        preparedStatement.setInt(1, count);
        preparedStatement.setString(2, item.getName());
        preparedStatement.setString(3, String.valueOf(item.getShoesType()));
        preparedStatement.setInt(4, item.getSize());
        preparedStatement.executeUpdate();
    }

    public T getPrice(String name, String type) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from  shoes where nameDevice=? and typeshoes=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, type);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            return (T) new Shoes();
        }
        return null;
    }
}
