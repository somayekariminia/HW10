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
    private static ShoesServiceImpl instance = new ShoesServiceImpl();

    private ShoesServiceImpl() {
    }

    public static ShoesServiceImpl getInstance() {
        return instance;
    }
    @Override
    public void updateStockItems(Shoes item, int count) throws SQLException {
        int id=getIdItem(String.valueOf(item.getItemType()),item.getCode());
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
    public int getIdItem(String typeProduct,String codeProduct) throws SQLException {
        return shoesRepository.getIdByItem(typeProduct,codeProduct);
    }

}
