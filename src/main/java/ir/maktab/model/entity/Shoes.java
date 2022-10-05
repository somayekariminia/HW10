package ir.maktab.model.entity;

import ir.maktab.model.enums.ShoesType;
import ir.maktab.model.enums.TypeProduct;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Shoes extends Item{
    private ShoesType shoesType;
    private int size;
    private String color;
    public Shoes(String code,String name, double price, int count, String typeProduct,int numberSelect, String shoesType, String color, int size) {
        super(code,name, price, count, TypeProduct.valueOf(typeProduct),numberSelect);
        this.shoesType = ShoesType.valueOf(shoesType);
        this.color = color;
        this.size = size;
    }

}
