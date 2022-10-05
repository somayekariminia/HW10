package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasketRepository {
   private static BasketRepository instance=new BasketRepository();
   private BasketRepository(){}
    public static BasketRepository getInstance(){
       return instance;
    }
    public void createBasketForUser(int userId) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into basket(userid,isconfirm) values(?,?)");
        preparedStatement.setInt(1, userId);
        preparedStatement.setBoolean(2, false);
        preparedStatement.executeUpdate();
    }
    public void updateBasket(int userId) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update basket set isconfirm=? where userId=?");
        preparedStatement.setInt(1, userId);
        preparedStatement.setBoolean(2, true);
        preparedStatement.executeUpdate();
    }
}
