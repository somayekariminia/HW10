package ir.maktab.service;

import ir.maktab.Repository.ShoesRepository;
import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.Shoes;
import ir.maktab.service.interfaces.ItemService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoesServiceImpl implements ItemService<Shoes> {
    ShoesRepository shoesRepository=new ShoesRepository();
    ArrayList<Shoes>list=new ArrayList<>();
    @Override
    public void updateStockItems(Shoes item, int count) throws SQLException {
        int id =getIdItem(item);
        shoesRepository.updateItems(id,count,item);
    }

    @Override
    public List<Shoes> printAllItemsTables() throws SQLException, NotFoundException {
       list= (ArrayList<Shoes>) shoesRepository.getProductsOfTable();
       if(list==null)
           throw  new NotFoundException("list is empty");
       else return list;
    }

    @Override
    public int getIdItem(Shoes item) throws SQLException {
        return shoesRepository.getIdByItem(item);
    }

}
