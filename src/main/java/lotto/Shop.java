package lotto;

import java.util.List;

public interface Shop<T extends Item> {
    void setItem(Class<? extends Item> itemType, int price);
    int getPrice(Class<? extends Item> itemType);
    List<T> buy(Class<? extends Item> itemType, int money);
}
