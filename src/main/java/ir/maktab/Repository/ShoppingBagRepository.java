package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ShoppingBagRepository {
//    private Map<Item,Integer> mapShopping=new HashMap<>();
//    private boolean isConfirm;
//    private int capacity;

    public void addItemToShoppingBag(int userId,int itemId,int count,String type) throws SQLException {
        Connection connection= GetConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into shoppingbag(UserId,ItemId,count,typer) values (?,?,?,?)");
        preparedStatement.setInt(1,userId);
        preparedStatement.setInt(2,itemId);
        preparedStatement.setInt(3,count);
        preparedStatement.setString(4,type);
        preparedStatement.executeUpdate();
    }


    public void deleteItemOfShoppingBag(int userId,int itemId ) throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("delete from shoppingbage where idItem=? and idItem=?");
    preparedStatement.setInt(1,userId);
    preparedStatement.setInt(2,itemId);
    preparedStatement.executeUpdate();
    }


    public List printAllItems(int id) throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from shoppingbag inner join item on shoppingbag.itemId=item.id where userId=?");
        preparedStatement.setInt(1,id);
        return null;
    }

}
