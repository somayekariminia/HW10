package ir.maktab.service;

import ir.maktab.Repository.DeviceRepository;
import ir.maktab.model.entity.Device;
import ir.maktab.model.enums.DevicesType;

import java.sql.SQLException;

public class DeviceServiceImpl implements ItemService<Device> {
    private DeviceRepository deviceRepository=new DeviceRepository();
    @Override
    public void updateStockItems(Device item, int count) throws SQLException {
     deviceRepository.updateItems(item.getName(), String.valueOf(item.getDevicesType()),item.getColor(),item.getInch());
    }
    @Override
    public int getIdItem(Device item) throws SQLException {
       return deviceRepository.getId(item.getName(),String.valueOf(item.getDevicesType()),item.getColor(),item.getInch());
    }

}
