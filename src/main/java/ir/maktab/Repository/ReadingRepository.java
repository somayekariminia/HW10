package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Reading;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadingRepository<T extends Reading> {
    public void addDevice(T item) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into reading(namereading,typereading,countpage,count,price) values (?,?,?,?,?)");
        preparedStatement.setString(1, item.getName());
        preparedStatement.setString(2, String.valueOf(item.getReadingType()));
        preparedStatement.setInt(3, item.getCountPage());
        preparedStatement.setInt(4, item.getCount());
        preparedStatement.setDouble(5, item.getPrice());
        preparedStatement.executeUpdate();
    }

    public void UpdateDevice(T item, int count) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update reading set count=? " +
                " where nameDevice=? and typeDevice=? and countpage=? ");
        preparedStatement.setInt(1, count);
        preparedStatement.setString(2, item.getName());
        preparedStatement.setString(3, String.valueOf(item.getReadingType()));
        preparedStatement.setInt(4, item.getCountPage());
        preparedStatement.executeUpdate();
    }

    public T getPrice(String name, String type) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from  reading where nameDevice=? and typereading=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, type);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            return (T) new Reading();
        }
        return null;
    }
}
