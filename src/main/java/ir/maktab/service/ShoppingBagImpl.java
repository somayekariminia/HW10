package ir.maktab.service;

import ir.maktab.Repository.BasketRepository;
import ir.maktab.Repository.ShoppingBagRepository;
import ir.maktab.Repository.UserRepository;
import ir.maktab.Repository.interfaces.ItemRepository;
import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.*;
import ir.maktab.service.interfaces.shoppingBagService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBagImpl implements shoppingBagService {
    List<Item> arrayList = new ArrayList<>();
    int capacity;
    boolean isConfirm;
    ItemRepository itemRepository;
    UserRepository userRepository = UserRepository.getInstance();
    ShoppingBagRepository shoppingBagRepository = new ShoppingBagRepository();
    ShoesServiceImpl shoesServiceImpl = ShoesServiceImpl.getInstance();
    DeviceServiceImpl deviceServiceImpl = DeviceServiceImpl.getInstance();
    ReadingServiceImpl readingServiceImpl = ReadingServiceImpl.getInstance();
    BasketRepository basketRepository = BasketRepository.getInstance();
    private static ShoppingBagImpl instance = new ShoppingBagImpl();

    private ShoppingBagImpl() {
    }

    public static ShoppingBagImpl getInstance() {
        return instance;
    }

    @Override
    public void addProductToShoppingBag(String typeItem, String codeItem, User user, int countSelect) throws NotFoundException, SQLException {
        int idUser = userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
        capacity = basketRepository.getCapacity(idUser);
        if (capacity > 5) {
            throw new NotFoundException("cont add to list shoppingBag that is full");
        } else {
            int idItem = getIdProduct(typeItem, codeItem);
            shoppingBagRepository.addItemToShoppingBag(idUser, idItem, countSelect, typeItem);
            capacity++;
            basketRepository.updateBasketForCapacity(idUser, capacity);
        }
    }

    @Override
    public void deleteProductOfShoppingBag(String typeItem, String codeItem, User user) throws SQLException, NotFoundException {

        int idItem = getIdProduct(typeItem, codeItem);
        int idUser = userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
        if (idItem == 0) {
            throw new NotFoundException("there isnt product");
        } else {
            if (idUser == 0)
                throw new NotFoundException("there isnt user");
            else {
                if (shoppingBagRepository.isExist(idUser, idItem, typeItem)) {
                    shoppingBagRepository.deleteItemOfShoppingBag(idUser, idItem, typeItem);
                    int capacity = basketRepository.getCapacity(idUser);
                    capacity--;
                    basketRepository.updateBasketForCapacity(idUser, capacity);
                }
                else
                    throw  new NotFoundException("is not exist");
            }
        }
    }

    @Override
    public List<Item> printAllProductsShoppingBag(User user) throws SQLException, NotFoundException {
        int id = userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
        arrayList = shoppingBagRepository.selectAllItems(id);
        if (arrayList == null)
            throw new NotFoundException("list productds is empty");
        else
            return arrayList;

    }

    @Override
    public double printTotalPrice(User user) throws SQLException, NotFoundException {
        double totalPrice = 0;
        List<Item> arrayList1 = new ArrayList<>();
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
        if(basketRepository.isConfirm(userId)) {
            basketRepository.updateBasketForIsConfirm(userId);
            arrayList = printAllProductsShoppingBag(user);
            if (arrayList == null)
                throw new NotFoundException("list is empty");
            else
                for (int i = 0; i < arrayList.size(); i++) {
                    int countTotal = arrayList.get(i).getCount();
                    int countSelect = arrayList.get(i).getNumberSelect();
                    countTotal = countTotal - countSelect;
                    if (arrayList.get(i) instanceof Device)
                        deviceServiceImpl.updateStockItems((Device) arrayList.get(i), countTotal);
                    else if (arrayList.get(i) instanceof Shoes)
                        shoesServiceImpl.updateStockItems((Shoes) arrayList.get(i), countTotal);
                    else if (arrayList.get(i) instanceof Reading)
                        readingServiceImpl.updateStockItems((Reading) arrayList.get(i), countTotal);
                }
        }
        else System.out.println("your shopping is confirmed");
    }

    public int getIdProduct(String typeItem, String codeItem) throws SQLException {
        int id = 0;
        if (typeItem.equals("device"))
            id = deviceServiceImpl.getIdItem(typeItem, codeItem);
        else if (typeItem.equals("reading"))
            id = readingServiceImpl.getIdItem(typeItem, codeItem);
        else if (typeItem.equals("shoes"))
            id = shoesServiceImpl.getIdItem(typeItem, codeItem);
        return id;
    }
}
