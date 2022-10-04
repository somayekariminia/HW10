package ir.maktab.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Item  {
    private String name;
    private double price;
    private int count;
}
