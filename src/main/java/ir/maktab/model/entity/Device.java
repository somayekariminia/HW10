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
}
