package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceRepository<T extends Device> extends ItemRepositoryAbstract <Device> {
    @Override
    public List<Device> getProductsOfTable() throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from device");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        List<Device> list=new ArrayList<>();
        while (resultSet1.next()) {
         Device   device = new Device(resultSet1.getString("codeProduct"),
                    resultSet1.getString("nameItem"),
                    resultSet1.getDouble("price"),
                    resultSet1.getInt("numberAvailable"),
                    resultSet1.getString("typeProduct"),
                    resultSet1.getInt("numberSelect"),
                    resultSet1.getString("typeItem"),
                    resultSet1.getString("color"),
                    resultSet1.getInt("inch"));
         list.add(device);

        }
        return list;
    }
}
