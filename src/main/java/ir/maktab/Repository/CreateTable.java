package ir.maktab.Repository;

import ir.maktab.Repository.cconnection.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
    public void createTableUser() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table users (id serial primary key "+
                ",username varchar(50)," +
                "password varchar(50))");
        preparedStatement.executeUpdate();
    }

    public void createTableShoppingBag() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table shoppingbag(id serial primary key ," +
                "UserId int," +
                "ItemId int," +
                "numberSelect int," +
                "typeProduct varchar(20)," +
                "foreign key (UserId) references users(id))");
        preparedStatement.executeUpdate();
    }

    public void createTableBasket() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table basket(id serial primary key ," +
                "UserId int," +
                "iscofirm boolean," +
                "foreign key (UserId) references users(id))");
        preparedStatement.executeUpdate();
    }

    public void createTableDevice() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table device(id serial primary key," +
                "nameItem varchar(50)," +
                "typeItem varchar(50)," +
                "color varchar(20)," +
                "inch int," +
                "numberAvailable int," +
                "price decimal)");
        preparedStatement.executeUpdate();

    }

    public void createTableShoes() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table shoes(id serial primary key," +
                "nameItem varchar(50)," +
                "typeItem varchar(50)," +
                "color varchar(20)," +
                "sizeshoes int," +
                "numberAvailable int," +
                "price decimal)");
        preparedStatement.executeUpdate();

    }

    public void createTableReading() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table reading(id serial primary key," +
                "nameItem varchar(50)," +
                "typeItem varchar(50)," +
                "numberPage int," +
                "numberAvailable int," +
                "price decimal)");
        preparedStatement.executeUpdate();

    }

}