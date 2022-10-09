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
        PreparedStatement preparedStatement = connection.prepareStatement("insert into shoppingbag(Userid,Itemid,numberselect,typeproduct) values (?,?,?,?)");
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, itemId);
        preparedStatement.setInt(3, count);
        preparedStatement.setString(4, type);
        preparedStatement.executeUpdate();
    }


    public void deleteItemOfShoppingBag(int userId, int itemId,String typeProduct) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from shoppingbag where userid=? and itemid=? and typeproduct=?");
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, itemId);
        preparedStatement.setString(3,typeProduct);
        preparedStatement.executeUpdate();
    }
public boolean isExist(int userId, int itemId, String typeProduct) throws SQLException {
    Connection connection = GetConnection.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("select * from shoppingbag where userid=? and itemid=? and typeproduct=?");
    preparedStatement.setInt(1, userId);
    preparedStatement.setInt(2, itemId);
    preparedStatement.setString(3, typeProduct);
    ResultSet resultSet=preparedStatement.executeQuery();
    return resultSet.next();
}

    public List<Item> selectAllItems(int id) throws SQLException {
       Connection connection = GetConnection.getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement("select * from shoppingbag where userId=?");
       preparedStatement.setInt(1, id);
       ResultSet resultSet = preparedStatement.executeQuery();
       List<Item> itemList = new ArrayList<>();
       while (resultSet.next()) {
           if (resultSet.getString("typeproduct").equals("device")) {
                 Device device=getDevice();
                   itemList.add(device);
               }
            else if (resultSet.getString("typeproduct").equals("reading")) {
                Reading reading=getReading();
                itemList.add(reading);
            } else if (resultSet.getString("typeproduct").equals("shoes")) {
                Shoes shoes=getShoes();
                itemList.add(shoes);
            }
        }
       return itemList;
    }
  private  Device getDevice() throws SQLException {
    Connection connection=GetConnection.getConnection();
      PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from  shoppingbag inner join device on shoppingbag.itemId=device.id");
      ResultSet resultSet1 = preparedStatement1.executeQuery();
      Device device=null;
      while (resultSet1.next()) {
          device = new Device(resultSet1.getString("codeProduct"),
                  resultSet1.getString("nameItem"),
                  resultSet1.getDouble("price"),
                  resultSet1.getInt("numberAvailable"),
                  resultSet1.getInt("numberSelect"),
                  resultSet1.getString("typeItem"),
                  resultSet1.getInt("inch"),
                  resultSet1.getString("color"));
  }
return device;
}
private Reading getReading() throws SQLException {
    Connection connection=GetConnection.getConnection();
    PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from  shoppingbag inner join reading on shoppingbag.itemId=reading.id");
    ResultSet resultSet1 = preparedStatement1.executeQuery();
    Reading reading=null;
    while (resultSet1.next()) {
        reading = new Reading(resultSet1.getString("codeProduct"),
                resultSet1.getString("nameItem"),
                resultSet1.getDouble("price"),
                resultSet1.getInt("numberAvailable"),
                resultSet1.getInt("numberSelect"),
                resultSet1.getString("typeitem"),
                resultSet1.getInt("numberPage"));
    }
    return reading;
}

    private Shoes getShoes() throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from  shoppingbag inner join shoes on shoppingbag.itemId=shoes.id");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
      Shoes shoes=null;
        while (resultSet1.next()) {
            shoes = new Shoes(resultSet1.getString("codeProduct"),
                    resultSet1.getString("nameItem"),
                    resultSet1.getDouble("price"),
                    resultSet1.getInt("numberAvailable"),
                    resultSet1.getInt("numberSelect"),
                    resultSet1.getString("typeItem"),
                    resultSet1.getString("color"),
                    resultSet1.getInt("sizeShoes"));
        }
        return shoes;
    }

    public void updateCountInShopping(int userId, int itemId, int count, String typeProduct) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update shoppingbag set numberselect=? where userid=? and itemid=? and typeproduct=?");
        preparedStatement.setInt(1, count);
        preparedStatement.setInt(2, userId);
        preparedStatement.setInt(3, itemId);
        preparedStatement.setString(4, typeProduct);
        preparedStatement.executeUpdate();
    }

    public int getCount(int userId, int itemId, String typeProduct) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select numberselect from shoppingbag where userid=? and itemid=? and typeProduct=?");
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, itemId);
        preparedStatement.setString(3, typeProduct);
        ResultSet resultSet = preparedStatement.executeQuery();
        int count = 0;
        while (resultSet.next()) {
            count = resultSet.getInt("numberselect");
        }
        return count;
    }


}
