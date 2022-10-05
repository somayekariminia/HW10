package ir.maktab.model.entity;

import ir.maktab.model.enums.ReadingType;
import ir.maktab.model.enums.TypeProduct;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Reading extends Item{
    private ReadingType readingType;
    private int countPage;
    private int countSelect;
    public Reading(String code,String name, double price, int count, String itemType,String readingType, int countPage,int countSelect) {
        super(code,name, price, count, TypeProduct.valueOf(itemType));
        this.readingType = ReadingType.valueOf(readingType);
        this.countPage = countPage;
        this.countSelect=countSelect;
    }
}
