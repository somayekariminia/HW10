package ir.maktab.model.entity;

import ir.maktab.model.enums.ReadingType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Reading extends Item {
    private ReadingType readingType;
    private int countPage;

}
