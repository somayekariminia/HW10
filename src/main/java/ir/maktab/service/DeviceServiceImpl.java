package ir.maktab.service;

import ir.maktab.Repository.DeviceRepository;
import ir.maktab.model.entity.Device;
import ir.maktab.service.interfaces.ItemService;

import java.sql.SQLException;

public class DeviceServiceImpl implements ItemService<Device> {
    private DeviceRepository deviceRepository=new DeviceRepository();
    @Override
    public void updateStockItems(Device item, int count) throws SQLException {
    int id=getIdItem(item);
   deviceRepository.updateItems(id,count,item);

    }
    @Override
    public int getIdItem(Device item) throws SQLException {
       return deviceRepository.getId(item.getName(),String.valueOf(item.getDevicesType()),item.getColor(),item.getInch());
    }

}
