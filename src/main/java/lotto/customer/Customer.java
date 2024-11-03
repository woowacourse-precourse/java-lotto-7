package lotto.customer;

import java.util.List;
import lotto.item.Item;

public interface Customer<T extends Item> {
    List<T> buy(Class<? extends Item> itemType, int money);
    void viewTotalProfit(long investment, long profit);
}
