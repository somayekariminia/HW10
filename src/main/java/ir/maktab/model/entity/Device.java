package ir.maktab.model.entity;

import ir.maktab.model.enums.DevicesType;
import ir.maktab.model.enums.TypeProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device extends Item{

    private DevicesType devicesType;
    private int inch;
    private String color;


    public Device(String code,String name, double price, int count, String typeProduct,int numberSelect, String devicesType, String color, int inch) {
        super(code, name, price, count, TypeProduct.valueOf(typeProduct),numberSelect);
        this.devicesType =DevicesType.valueOf(devicesType);
        this.inch = inch;
        this.color = color;

    }

    public Device(String code, String name, double price, int count, String devicesType, int inch, String color) {
        super(code, name, price, count);
        this.devicesType = DevicesType.valueOf(devicesType);
        this.inch = inch;
        this.color = color;

    }
}
