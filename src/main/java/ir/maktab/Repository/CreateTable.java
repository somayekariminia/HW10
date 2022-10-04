package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
    void createTableUser() throws SQLException {
        Connection connection= GetConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("create table user (id serial primary key ," +
                "username varchar(50)," +
                "password varchar(50))");
        preparedStatement.executeUpdate();
    }
    void createTableShoppingBag() throws SQLException {
        Connection connection=GetConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("create table shoppingbag(id serial primary key ," +
                "UserId int," +
                "ItemId int," +
                "count int," +
                "type varchar(20),"+
                "foreign key (UserId) references user(id)," +
                "foreign key (ItemId) references item(id))");
        preparedStatement.executeUpdate();
    }
    void createTableItem() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table item(id serial primary key," +
                "nameItem varchar(50)," +
                "typeItem varchar(50)," +
                " color varchar(20)," +
                "size int," +
                "countItem int," +
                "price decimal)");
        preparedStatement.executeUpdate();
    }

    }

