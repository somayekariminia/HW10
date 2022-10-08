package ir.maktab.service;

import ir.maktab.Repository.BasketRepository;
import ir.maktab.Repository.UserRepository;
import ir.maktab.model.entity.User;
import ir.maktab.service.interfaces.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    UserRepository userRepository=UserRepository.getInstance();
    BasketRepository basketRepository=BasketRepository.getInstance();
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }
    @Override
    public void registerUser(User user) throws SQLException {
        userRepository.registerUser(user);
        int id=userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
        basketRepository.createBasketForUser(id);
    }
    @Override
    public boolean loginUser(String name, String password) throws SQLException {
     if(userRepository.loginUser(name,password)==null)
         return false;
     else
         return true;
    }
}
