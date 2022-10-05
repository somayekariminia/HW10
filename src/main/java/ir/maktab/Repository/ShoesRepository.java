package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Shoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoesRepository<T extends Shoes> extends ItemRepositoryAbstract<Shoes>{
    @Override
    public List<Shoes> getProductsOfTable() throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from shoes");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        List<Shoes> list=new ArrayList<>();
        while (resultSet1.next()) {
          Shoes  shoes = new Shoes(resultSet1.getString("codeProduct"),
                    resultSet1.getString("nameItem"),
                    resultSet1.getDouble("price"),
                    resultSet1.getInt("numberAvailable"),
                    resultSet1.getString("typeProduct"),
                    resultSet1.getInt("numberSelect"),
                    resultSet1.getString("typeItem"),
                    resultSet1.getString("color"),
                    resultSet1.getInt("sizeShoes"));
          list.add(shoes);
        }
        return list;
    }
}
