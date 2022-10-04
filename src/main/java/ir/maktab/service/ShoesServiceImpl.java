package ir.maktab.service;

import ir.maktab.Repository.ShoesRepository;
import ir.maktab.model.entity.Shoes;

import java.sql.SQLException;

public class ShoesServiceImpl implements ItemService<Shoes>{
    ShoesRepository shoesRepository=new ShoesRepository();
    @Override
    public void updateStockItems(Shoes item, int count) throws SQLException {
       shoesRepository.updateItems(item.getName(), String.valueOf(item.getShoesType()),item.getColor(),item.getSize());
    }

    @Override
    public int getIdItem(Shoes item) throws SQLException {
        return shoesRepository.getId(item.getName(),String.valueOf(item.getShoesType()),item.getColor(),item.getSize());
    }
}
