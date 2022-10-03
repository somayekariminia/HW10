package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Item;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceRepository<T extends Device> extends ItemRepositoryAbstract <Device> {
  public void addDevice(T item) throws SQLException {
    Connection connection= GetConnection.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("insert into item(nameItem,typeItem,color,count,price,size) values (?,?,?,?,?,?)");
    preparedStatement.setString(1,item.getName());
    preparedStatement.setString(2,String.valueOf(item.getDevicesType()));
    preparedStatement.setString(3,item.getColor());
    preparedStatement.setInt(4,item.getCount());
    preparedStatement.setDouble(5,item.getPrice());
    preparedStatement.setInt(6,item.getInch());
    preparedStatement.executeUpdate();
  }

}
