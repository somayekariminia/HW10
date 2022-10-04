package ir.maktab.service;

import ir.maktab.model.entity.Reading;

import java.sql.SQLException;

public class ReadingServiceImpl implements ItemService<Reading> {

    @Override
    public void updateStockItems(Reading item, int count) throws SQLException {

    }

    @Override
    public int getIdItem(Reading item) throws SQLException {
        return 0;
    }
}
