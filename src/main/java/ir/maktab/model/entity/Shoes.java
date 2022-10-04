package ir.maktab.model.entity;

import ir.maktab.model.enums.ShoesType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Shoes extends Item{
    private ShoesType shoesType;
    private int size;
    private String color;
    private int selectCount;
    public Shoes(String name, double price, int count, String shoesType,  String color,int size,int selectCount) {
        super(name, price, count);
        this.shoesType = ShoesType.valueOf(shoesType);
        this.color = color;
        this.size = size;
        this.selectCount=selectCount;
    }


}
