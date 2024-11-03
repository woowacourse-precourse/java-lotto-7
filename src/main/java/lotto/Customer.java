package lotto;

import java.util.List;

public interface Customer<T extends Item> {
    List<T> buy(Class<? extends Item> itemType, int money);
    void viewTotalProfit(long investment, long profit);
}
