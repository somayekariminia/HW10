package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Reading;
import ir.maktab.model.entity.Shoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBagRepository {
    public void addItemToShoppingBag(int userId, int itemId, int count, String type) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into shoppingbag(UserId,ItemId,count,typer) values (?,?,?,?)");
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, itemId);
        preparedStatement.setInt(3, count);
        preparedStatement.setString(4, type);
        preparedStatement.executeUpdate();
    }


    public void deleteItemOfShoppingBag(int userId, int itemId) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from shoppingbage where idItem=? and idItem=?");
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, itemId);
        preparedStatement.executeUpdate();
    }


    public List<Item> printAllItems(int id) throws SQLException {
//       Connection connection = GetConnection.getConnection();
//       PreparedStatement preparedStatement = connection.prepareStatement("select * from shoppingbag inner join item on shoppingbag.itemId=item.id where userId=?");
//       preparedStatement.setInt(1, id);
//       ResultSet resultSet = preparedStatement.executeQuery();
//       List<Item> itemList = new ArrayList<>();
//       while (resultSet.next()) {
//           if (resultSet.getString("type").equals("device")) {
//               Device device = new Device(resultSet.getString("nameItem"), resultSet.getDouble("price"), resultSet.getInt("countItem"), resultSet.getString("typeItem"), resultSet.getString("color"), resultSet.getInt("size"), resultSet.getInt("count"));
//               itemList.add(device);
//           } else if (resultSet.getString("type").equals("reading")) {
//                Reading reading = new Reading(resultSet.getString("nameItem"), resultSet.getDouble("price"), resultSet.getInt("countItem"), resultSet.getString("typeItem"), resultSet.getInt("size"), resultSet.getInt("count"));
//                itemList.add(reading);
//            } else if (resultSet.getString("type").equals("reading")) {
//                Shoes shoes = new Shoes(resultSet.getString("nameItem"), resultSet.getDouble("price"), resultSet.getInt("count"), resultSet.getString("typeItem"), resultSet.getString("color"), resultSet.getInt("size"), resultSet.getInt("count"));
//                itemList.add(shoes);
//            }
//        }
//       return itemList;
//       return null;
//    }
        return null;
    }
}
