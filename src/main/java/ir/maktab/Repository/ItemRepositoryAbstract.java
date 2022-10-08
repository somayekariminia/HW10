package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;
import ir.maktab.Repository.interfaces.ItemRepository;
import ir.maktab.model.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class ItemRepositoryAbstract<T extends Item> implements ItemRepository<T> {

    @Override
    public void updateItems(int id, int count, T item) throws SQLException {
        Connection connection = GetConnection.getConnection();
        String string = "update" + " " + item.getItemType() + " " + " set numberavailable=? " + " " + " where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(string);
        preparedStatement.setInt(1, count);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public abstract List<T> getProductsOfTable() throws SQLException;

    public int getIdByItem(String typeProduct,String codeProduct) throws SQLException {
        Connection connection = GetConnection.getConnection();
        String str = "select *" + " " + " from " + typeProduct + " where  (codeproduct=?)";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        preparedStatement.setString(1,codeProduct);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id=0;
        while (resultSet.next()) {
          id=resultSet.getInt("id");
        }
        return id;
    }
}
