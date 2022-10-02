package ir.maktab.model.entity;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBag {
    Map<Item,Integer> mapShopping=new HashMap<>();
    User user;
    private boolean isConfirm;
}
