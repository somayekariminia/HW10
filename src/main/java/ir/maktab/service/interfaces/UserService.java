package ir.maktab.service.interfaces;

import ir.maktab.model.entity.User;

import java.sql.SQLException;

public interface UserService {
     void registerUser(User user) throws SQLException;
     boolean loginUser(String name,String password) throws SQLException;
}
