package ir.maktab.service;

import ir.maktab.Repository.ReadingRepository;
import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.Reading;
import ir.maktab.service.interfaces.ItemService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadingServiceImpl implements ItemService<Reading> {
    private ReadingRepository readingRepository = new ReadingRepository();
    private static ReadingServiceImpl instance = new ReadingServiceImpl();

    private ReadingServiceImpl() {
    }

    public static ReadingServiceImpl getInstance() {
        return instance;
    }

    ArrayList<Reading> arrayList = new ArrayList<>();

    @Override
    public void updateStockItems(Reading item, int count) throws SQLException {
        int id=getIdItem(String.valueOf(item.getItemType()),item.getCode());
        readingRepository.updateItems(id, count, item);
    }

    @Override
    public List<Reading> printAllItemsTables() throws SQLException, NotFoundException {
      arrayList= (ArrayList<Reading>) readingRepository.getProductsOfTable();
      if(arrayList==null)
          throw new NotFoundException("list is empty");
      else return arrayList;

    }

    @Override
    public int getIdItem(String typeProduct,String codeProduct) throws SQLException {
        return readingRepository.getIdByItem(typeProduct,codeProduct);
    }

    @Override
    public int getNumberAvailableItem(String typeProduct, String codeProduct) throws SQLException {
        return readingRepository.getNumberAvailableByItem(typeProduct,codeProduct);
    }

}
