package ir.maktab.model.entity;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBag {
    private Map<Item,Integer> mapShopping=new HashMap<>();
    private boolean isConfirm;
    private int capacity;
}
