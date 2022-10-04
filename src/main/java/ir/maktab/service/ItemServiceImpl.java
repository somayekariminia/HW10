package ir.maktab.service;

import ir.maktab.Repository.ItemRepositoryAbstract;
import ir.maktab.model.entity.Item;

public class ItemServiceImpl<T extends Item> implements ItemService<T>{
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
