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

public class ReadingRepository extends ItemRepositoryAbstract<Reading> {
    @Override
    public List<Reading> getProductsOfTable() throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from reading");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        List<Reading> list=new ArrayList<>();
        while (resultSet1.next()) {
        Reading reading = new Reading(resultSet1.getString("codeproduct"),
                    resultSet1.getString("nameitem"),
                    resultSet1.getDouble("price"),
                    resultSet1.getInt("numberavailable"),
                    resultSet1.getString("typeitem"),
                    resultSet1.getInt("numberPage"));
        list.add(reading);
        }
        return list;
    }
}

