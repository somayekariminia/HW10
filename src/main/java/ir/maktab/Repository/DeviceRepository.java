package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Item;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceRepository<T extends Device> {
  public void addDevice(T item) throws SQLException {
    Connection connection= GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("insert into device(nameDevice,typeDevice,color,count,price,inch) values (?,?,?,?,?)");
    preparedStatement.setString(1,item.getName());
    preparedStatement.setString(2,String.valueOf(item.getDevicesType()));
    preparedStatement.setString(3,item.getColor());
    preparedStatement.setInt(3,item.getCount());
    preparedStatement.setDouble(4,item.getPrice());
    preparedStatement.setInt(5,item.getInch());
    preparedStatement.executeUpdate();
  }
  public  void UpdateDevice(T item,int count) throws SQLException {
    Connection connection= GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("update devic set count=? " +
            " where nameDevice=? and typeDevice=? and inch=? ");
    preparedStatement.setInt(1,count);
    preparedStatement.setString(2,item.getName());
    preparedStatement.setString(3,String.valueOf(item.getDevicesType()));
    preparedStatement.setInt(4,item.getInch());
    preparedStatement.executeUpdate();
  }
  public T getPrice(String name, String type) throws SQLException {
    Connection connection= GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("SELECT * from  devic where nameDevice=?");
    preparedStatement.setString(1,name);
    preparedStatement.setString(2,type);
    ResultSet result=preparedStatement.executeQuery();
    while(result.next())
    {
      return (T) new Device();
    }
    return null;
  }
}
