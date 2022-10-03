package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeviceRepository<T extends Device> {
  public void addDevice(T item) throws SQLException {
    Connection connection= GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("insert into device(nameDevice,typeDevice,count,price,inch) values (?,?,?,?,?)");
    preparedStatement.setString(1,item.getName());
    preparedStatement.setString(2,String.valueOf(item.getDevicesType()));
    preparedStatement.setInt(3,item.getCount());
    preparedStatement.setDouble(4,item.getPrice());
    preparedStatement.setInt(5,item.getInch());
    preparedStatement.executeUpdate();
  }
}
