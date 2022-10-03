package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Reading;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadingRepository<T extends Reading> extends ItemRepositoryAbstract<Reading> {
    public void addDevice(T item) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into item(namereading,typereading,countpage,count,price) values (?,?,?,?,?)");
        preparedStatement.setString(1, item.getName());
        preparedStatement.setString(2, String.valueOf(item.getReadingType()));
        preparedStatement.setInt(3, item.getCountPage());
        preparedStatement.setInt(4, item.getCount());
        preparedStatement.setDouble(5, item.getPrice());
        preparedStatement.executeUpdate();
    }
}
