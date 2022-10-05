package ir.maktab.service;

import ir.maktab.Repository.ShoppingBagRepository;
import ir.maktab.Repository.UserRepository;
import ir.maktab.Repository.BasketRepository;
import ir.maktab.Repository.interfaces.ItemRepository;
import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.*;
import ir.maktab.service.interfaces.shoppingBagService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingBagImpl implements shoppingBagService {
    ArrayList<Item> arrayList = new ArrayList<>();
    int capacity;
    boolean isConfirm;
    ItemRepository itemRepository;
    UserRepository userRepository;
    ShoppingBagRepository shoppingBagRepository;
    ShoesServiceImpl shoesServiceImpl;
    DeviceServiceImpl deviceServiceImpl;
    ReadingServiceImpl readingServiceImpl;
    BasketRepository basketRepository;
    @Override
    public void addProductToShoppingBag(Item item, User user, int countSelect) throws NotFoundException, SQLException {
        if (capacity > 5) {
            throw new NotFoundException("cont add to list shoppingBag that is full");
        } else {
            int idItem = itemRepository.getIdByItem(item);
            int idUser = userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
            shoppingBagRepository.addItemToShoppingBag(idUser, idItem, countSelect, String.valueOf(item.getItemType()));
            capacity++;
        }
    }
    @Override
    public void deleteProductOfShoppingBag(Item item, User user) throws SQLException, NotFoundException {

        int idItem = itemRepository.getIdByItem(item);
        int idUser = userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
        if (idItem == 0) {
            throw new NotFoundException("there isnt product");
        } else {
            if (idUser == 0)
                throw new NotFoundException("there isnt user");
            else {
                shoppingBagRepository.deleteItemOfShoppingBag(idItem, idUser);
                capacity--;
            }
        }
    }

    @Override
    public ArrayList<Item> printAllProductsShoppingBag(User user) throws SQLException, NotFoundException {
        int id = userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
        arrayList = (ArrayList<Item>) shoppingBagRepository.selectAllItems(id);
        if (arrayList == null)
            throw new NotFoundException("list productds is empty");
        else
            return arrayList;

    }

    @Override
    public double printTotalPrice(User user) throws SQLException, NotFoundException {
        double totalPrice = 0;
        ArrayList<Item> arrayList1 = new ArrayList<>();
        arrayList1 = printAllProductsShoppingBag(user);
        if (arrayList == null)
            throw new NotFoundException("list is empty");
        else
        {
            for (int i = 0; i < arrayList1.size(); i++) {
                totalPrice += arrayList1.get(i).getPrice() * arrayList1.get(i).getNumberSelect();
            }
            return totalPrice;
        }
    }

    @Override
    public void isConfirmShoppingBag(User user) throws SQLException, NotFoundException {
        int userId = userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
        basketRepository.updateBasket(userId);
        arrayList = printAllProductsShoppingBag(user);
        if (arrayList == null)
            throw new NotFoundException("list is empty");
        else
            for (int i = 0; i < arrayList.size(); i++) {
                int countTotal = arrayList.get(i).getCount();
                int countSelect = arrayList.get(i).getNumberSelect();
                countTotal = countTotal - countSelect;
                String typeProduct = String.valueOf(arrayList.get(i).getItemType());
                if (typeProduct.equals("device"))
                    deviceServiceImpl.updateStockItems((Device) arrayList.get(i), countTotal);
                else if (typeProduct.equals("shoes"))
                    shoesServiceImpl.updateStockItems((Shoes) arrayList.get(i), countTotal);
                else if (typeProduct.equals("reading"))
                    readingServiceImpl.updateStockItems((Reading) arrayList.get(i), countTotal);
            }
    }
}
