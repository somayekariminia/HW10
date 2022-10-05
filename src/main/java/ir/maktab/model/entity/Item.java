package ir.maktab.model.entity;

import ir.maktab.model.enums.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class Item{
  Random random=new Random();
    String code;
    private String name;
    private double price;
    private int count;
    private TypeProduct itemType;
    private  int numberSelect;

  public Item(String code, String name, double price, int count, TypeProduct itemType,int numberSelect) {
    this.code = code;
    this.name = name;
    this.price = price;
    this.count = count;
    this.itemType = itemType;
    this.numberSelect=numberSelect;
  }

  public Item(String code, String name, double price, int count) {
    this.code = code;
    this.name = name;
    this.price = price;
    this.count = count;
  }


  public String getCode() {
    return String.valueOf(itemType)+random.nextInt(100,1000);
  }
}
