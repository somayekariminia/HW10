package ir.maktab.model.entity;

import ir.maktab.model.enums.DevicesType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device extends Item {

    private DevicesType devicesType;
    private int inch;
    private String color;
    private int countSelect;

    public Device(String name, double price, int count, String devicesType, String color,int inch,int countSelect) {
        super(name, price, count);
        this.devicesType =DevicesType.valueOf(devicesType);
        this.inch = inch;
        this.color = color;
        this.countSelect=countSelect;
    }
}
