package ir.maktab.model.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
   private String name;
    private String password;
    private ShoppingBag shoppingBag;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
