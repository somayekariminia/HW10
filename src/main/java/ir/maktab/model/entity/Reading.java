package ir.maktab.model.entity;

import ir.maktab.model.enums.ReadingType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Reading extends Item {
    private ReadingType readingType;
    private int countPage;
    private int countSelect;
    public Reading(String name, double price, int count, String readingType, int countPage,int countSelect) {
        super(name, price, count);
        this.readingType = ReadingType.valueOf(readingType);
        this.countPage = countPage;
        this.countSelect=countSelect;
    }
}
