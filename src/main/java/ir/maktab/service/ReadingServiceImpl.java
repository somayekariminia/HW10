package ir.maktab.service;

import ir.maktab.Repository.ReadingRepository;
import ir.maktab.model.entity.Reading;
import ir.maktab.service.interfaces.ItemService;

import java.sql.SQLException;

public class ReadingServiceImpl implements ItemService<Reading> {
    ReadingRepository readingRepository=new ReadingRepository();

    @Override
    public void updateStockItems(Reading item, int count) throws SQLException {

        int id=getIdItem(item);
        readingRepository.updateItems(id,count,item);
    }
    @Override
    public int getIdItem(Reading item) throws SQLException {
        return readingRepository.getId(item.getName(), String.valueOf(item.getReadingType()),null,item.getCount());
    }
}
