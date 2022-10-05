package ir.maktab.service;

import ir.maktab.Repository.ShoesRepository;
import ir.maktab.model.entity.Shoes;
import ir.maktab.service.interfaces.ItemService;

import java.sql.SQLException;

public class ShoesServiceImpl implements ItemService<Shoes> {
    ShoesRepository shoesRepository=new ShoesRepository();
    @Override
    public void updateStockItems(Shoes item, int count) throws SQLException {
        int id =getIdItem(item);
        shoesRepository.updateItems(id,count,item);
    }

    @Override
    public int getIdItem(Shoes item) throws SQLException {
        return shoesRepository.getId(item.getName(),String.valueOf(item.getShoesType()),item.getColor(),item.getSize());
    }
}
