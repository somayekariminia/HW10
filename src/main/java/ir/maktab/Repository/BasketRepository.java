package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketRepository {
   private static BasketRepository instance=new BasketRepository();
   private BasketRepository(){}
    public static BasketRepository getInstance(){
       return instance;
    }
    public void createBasketForUser(int userId) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into basket(userid,isconfirm,capacity) values(?,?,?)");
        preparedStatement.setInt(1, userId);
        preparedStatement.setBoolean(2, false);
        preparedStatement.setInt(3,0);
        preparedStatement.executeUpdate();
    }
    public void updateBasketForIsConfirm(int userId) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update basket set isconfirm=?,capacity=? where userId=?");
        preparedStatement.setBoolean(1, true);
        preparedStatement.setInt(2,0);
        preparedStatement.setInt(3, userId);
        preparedStatement.executeUpdate();
    }
    public void updateBasketForCapacity(int userId,int capacity) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update basket set capacity=? where userId=?");
        preparedStatement.setInt(1, capacity);
        preparedStatement.setInt(2, userId);
        preparedStatement.executeUpdate();
    }
    public int getCapacity(int userId) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from basket where userid=?");
        preparedStatement.setInt(1,userId);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next())
        {
            return resultSet.getInt("capacity");
        }
        return 0;
    }
    public Boolean isConfirm(int userId) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from basket where userid=? and isconfirm=?");
        preparedStatement.setInt(1,userId);
        preparedStatement.setBoolean(2,false);
        ResultSet resultSet=preparedStatement.executeQuery();
        return resultSet.next();
    }
}
