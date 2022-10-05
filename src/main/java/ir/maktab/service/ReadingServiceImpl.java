package ir.maktab.service;

import ir.maktab.Repository.ReadingRepository;
import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.Device;
import ir.maktab.model.entity.Reading;
import ir.maktab.service.interfaces.ItemService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadingServiceImpl implements ItemService<Reading> {
    ReadingRepository readingRepository=new ReadingRepository();
    ArrayList<Reading>arrayList=new ArrayList<>();

    @Override
    public void updateStockItems(Reading item, int count) throws SQLException {
        int id=getIdItem(item);
        readingRepository.updateItems(id,count,item);
    }

    @Override
    public List<Reading> printAllItemsTables() throws SQLException, NotFoundException {
      arrayList= (ArrayList<Reading>) readingRepository.getProductsOfTable();
      if(arrayList==null)
          throw new NotFoundException("list is empty");
      else return arrayList;

    }

    @Override
    public int getIdItem(Reading item) throws SQLException {
        return readingRepository.getIdByItem(item);
    }

}
