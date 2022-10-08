package ir.maktab.model.entity;

import ir.maktab.model.enums.ShoesType;
import ir.maktab.model.enums.TypeProduct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Shoes extends Item{
    private ShoesType shoesType;
    private int size;
    private String color;
    public Shoes(String code,String name, double price, int count,int numberSelect, String shoesType, String color, int size) {
        super(code,name, price, count, TypeProduct.valueOf("shoes"),numberSelect);
        this.shoesType = ShoesType.valueOf(shoesType);
        this.color = color;
        this.size = size;
    }
    public Shoes(String code,String name, double price,int count, String shoesType, String color, int size) {
        super(code,name, price,count);
        this.shoesType = ShoesType.valueOf(shoesType);
        this.color = color;
        this.size = size;
    }

    @Override
    public String print() {
        return super.print();
    }

    @Override
    public String toString() {
        return  super.toString()+
                "  shoesType: " + shoesType +
                "  size=" + size +
                "  color='" + color ;
    }
}
