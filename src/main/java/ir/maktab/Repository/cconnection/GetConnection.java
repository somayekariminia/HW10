package ir.maktab.Repository.cconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

    private static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "12345";

    private static Connection connection;
    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }
}
