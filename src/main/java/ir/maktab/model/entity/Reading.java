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
    public Reading(String code,String name, double price, int count, String itemType,int numberSelect,String readingType, int countPage) {
        super(code,name, price, count, TypeProduct.valueOf(itemType),numberSelect);
        this.readingType = ReadingType.valueOf(readingType);
        this.countPage = countPage;

    }

}
