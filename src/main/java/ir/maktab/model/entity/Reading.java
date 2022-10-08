package ir.maktab.model.entity;

import ir.maktab.model.enums.ReadingType;
import ir.maktab.model.enums.TypeProduct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Reading extends Item{
    private ReadingType readingType;
    private int countPage;
    public Reading(String code,String name, double price, int count,int numberSelect,String readingType, int countPage) {
        super(code,name, price, count, TypeProduct.valueOf("reading"),numberSelect);
        this.readingType = ReadingType.valueOf(readingType);
        this.countPage = countPage;

    }
    public Reading(String code,String name, double price,int count,String readingType, int countPage) {
        super(code,name, price,count);
        this.readingType = ReadingType.valueOf(readingType);
        this.countPage = countPage;
    }

    public Reading(String name, String itemType) {
        super(name, itemType);
    }

    @Override
    public String print() {
        return super.print();
    }

    @Override
    public String toString() {
        return  super.toString()+
                "  readingType=" + readingType +
                "  countPage=" + countPage ;
    }
}
