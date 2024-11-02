package lotto.shop;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import lotto.item.Item;

public interface Shop<T extends Item> {
    void setItem(Class<? extends Item> itemType, int price);
    int getPrice(Class<? extends Item> itemType);
    List<T> buy(Class<? extends Item> itemType, int money)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
