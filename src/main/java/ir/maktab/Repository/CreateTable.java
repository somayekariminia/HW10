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
                "foreign key (UserId) references user(id)," +
                "foreign key (ItemId) references item(id))");
        preparedStatement.executeUpdate();
    }
    void createTableItem() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table item(id serial primary key," +
                "name varchar(50)," +
                "type varchar(50)," +
                "count int," +
                "price decimal," +
                "description varchar(50) )");
        preparedStatement.executeUpdate();
    }

    }

