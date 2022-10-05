package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Reading;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadingRepository<T extends Reading> extends ItemRepositoryAbstract<Reading> {
    @Override
    public List<Reading> getProductsOfTable() throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from reading");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        List<Reading> list=new ArrayList<>();
        while (resultSet1.next()) {
        Reading reading = new Reading(resultSet1.getString("codeProduct"),
                    resultSet1.getString("nameItem"),
                    resultSet1.getDouble("price"),
                    resultSet1.getInt("numberAvailable"),
                    resultSet1.getString("typeProduct"),
                    resultSet1.getInt("numberPage"),
                    resultSet1.getString("typeItem"),
                    resultSet1.getInt("numberSelect"));
        list.add(reading);
        }
        return list;
    }
}

