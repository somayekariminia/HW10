package ir.maktab.service;

import ir.maktab.Repository.BasketRepository;
import ir.maktab.Repository.ShoppingBagRepository;
import ir.maktab.Repository.UserRepository;
import ir.maktab.exeption.NotFoundException;
import ir.maktab.model.entity.*;
import ir.maktab.service.interfaces.shoppingBagService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBagImpl implements shoppingBagService {
    List<Item> arrayList = new ArrayList<>();
    int capacity;
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
        int countProduct;
        if (capacity >= 5) {
            throw new NotFoundException("cont add to list shoppingBag that is full");
        } else {
            countProduct = getStockProducts(typeItem, codeItem);
            if (countSelect <= countProduct) {
                int idItem = getIdProduct(typeItem, codeItem);
                if (!shoppingBagRepository.isExist(idUser, idItem, typeItem)) {
                    shoppingBagRepository.addItemToShoppingBag(idUser, idItem, countSelect, typeItem);
                    capacity++;
                } else {
                    int countNew = shoppingBagRepository.getCount(idUser, idItem, typeItem) + countSelect;
                    if (countNew <= countProduct)
                        shoppingBagRepository.updateCountInShopping(idUser, idItem, countNew, typeItem);
                    else System.out.println("Not Enough available ");
                }
                basketRepository.updateBasketForCapacity(idUser, capacity);
            } else
                System.out.println("Not Enough available ");
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
        List<Item> arrayList1;
        arrayList1 = printAllProductsShoppingBag(user);
        if (arrayList == null)
            throw new NotFoundException("list is empty");
        else {
            for (Item item : arrayList1) {
                totalPrice += item.getPrice() * item.getNumberSelect();
            }
            return totalPrice;
        }
    }

    @Override
    public boolean isConfirmShoppingBag(User user) throws SQLException, NotFoundException {
        int userId = userRepository.getIdByNameAndPassword(user.getName(), user.getPassword());
        if (basketRepository.isConfirm(userId)) {
            arrayList = printAllProductsShoppingBag(user);
            if (arrayList == null)
                throw new NotFoundException("list is empty");
            else
                for (Item item : arrayList) {
                    int countTotal = item.getCount();
                    int countSelect = item.getNumberSelect();
                    countTotal = countTotal - countSelect;
                    if (item instanceof Device)
                        deviceServiceImpl.updateStockItems((Device) item, countTotal);
                    else if (item instanceof Shoes)
                        shoesServiceImpl.updateStockItems((Shoes) item, countTotal);
                    else if (item instanceof Reading)
                        readingServiceImpl.updateStockItems((Reading) item, countTotal);
                }
            shoppingBagRepository.emptyShoppingBag(userId);
            basketRepository.updateBasketForIsConfirm(userId);
            return true;
        } else
            return false;
    }

    public int getIdProduct(String typeItem, String codeItem) throws SQLException {
        int id = switch (typeItem) {
            case "device" -> deviceServiceImpl.getIdItem(typeItem, codeItem);
            case "reading" -> readingServiceImpl.getIdItem(typeItem, codeItem);
            case "shoes" -> shoesServiceImpl.getIdItem(typeItem, codeItem);
            default -> 0;
        };
        return id;
    }

    private int getStockProducts(String typeItem, String codeItem) throws SQLException {
        return switch (typeItem) {
            case "device" -> deviceServiceImpl.getNumberAvailableItem(typeItem, codeItem);
            case "reading" -> readingServiceImpl.getNumberAvailableItem(typeItem, codeItem);
            case "shoes" -> shoesServiceImpl.getNumberAvailableItem(typeItem, codeItem);
            default -> 0;
        };
    }

}
