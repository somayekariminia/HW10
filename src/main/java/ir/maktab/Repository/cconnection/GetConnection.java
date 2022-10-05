package ir.maktab.Repository.cconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    public static Connection getConnection() throws SQLException {

            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/shopping","postgres","12345");
    }
}
