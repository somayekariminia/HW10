package ir.maktab.service;

import ir.maktab.model.entity.Item;
import ir.maktab.service.interfaces.ItemService;

public class ItemServiceImpl<T extends Item> implements ItemService<T> {
   private static ItemServiceImpl instance=new ItemServiceImpl();
   private ItemServiceImpl() {}
    public static ItemServiceImpl getInstance(){
       return instance;
    }
    @Override
    public void updateStockItems(T item, int count) {
    }
 @Override
 public int getIdItem(T item) {
  return 0;
 }
}
