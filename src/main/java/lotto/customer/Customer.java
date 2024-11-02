package lotto.customer;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import lotto.item.Item;

public interface Customer<T extends Item> {
    List<T> buy(Class<? extends Item> itemType, int money);
    void viewExpenditureSummary(long investment, long profit);
}
