package ir.maktab.Repository.interfaces;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasketRepository {
    public void createBasketForUser(int userId) throws SQLException {
        Connection connection= GetConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into basket(userid,isconfirm) values(?,?)");
        preparedStatement.setInt(1,userId);
        preparedStatement.setBoolean(2,false);
        preparedStatement.executeUpdate();
    }
    public void
}
