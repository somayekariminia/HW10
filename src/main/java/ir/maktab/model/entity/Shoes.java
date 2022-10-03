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
}
