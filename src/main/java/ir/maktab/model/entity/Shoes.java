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
    private int selectCount;
    public Shoes(String code,String name, double price, int count, String typeProduct, String shoesType, String color, int size, int selectCount) {
        super(code,name, price, count, TypeProduct.valueOf(typeProduct));
        this.shoesType = ShoesType.valueOf(shoesType);
        this.color = color;
        this.size = size;
        this.selectCount=selectCount;
    }

}
