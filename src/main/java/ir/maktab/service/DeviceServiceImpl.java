package ir.maktab.service;

import ir.maktab.Repository.DeviceRepository;
import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.Device;
import ir.maktab.service.interfaces.ItemService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceServiceImpl implements ItemService<Device> {
    private DeviceRepository deviceRepository=new DeviceRepository();
    private static DeviceServiceImpl instance=new DeviceServiceImpl();
    private DeviceServiceImpl(){}
    public  static DeviceServiceImpl getInstance(){
        return instance;
    }

    ArrayList <Device>arrayList=new ArrayList<>();
    @Override
    public void updateStockItems(Device item, int count) throws SQLException {
    int id=getIdItem(String.valueOf(item.getItemType()),item.getCode());
   deviceRepository.updateItems(id,count,item);

    }

    @Override
    public List<Device> printAllItemsTables() throws SQLException, NotFoundException {
       arrayList= (ArrayList<Device>) deviceRepository.getProductsOfTable();
       if(arrayList==null)
           throw new NotFoundException("list is empty");
       return arrayList;
    }

    @Override
    public int getIdItem(String typeProduct,String codeProduct) throws SQLException {
       return deviceRepository.getIdByItem(typeProduct,codeProduct);
    }

    @Override
    public int getNumberAvailableItem(String typeProduct, String codeProduct) throws SQLException {
        return deviceRepository.getNumberAvailableByItem(typeProduct,codeProduct);
    }

}
