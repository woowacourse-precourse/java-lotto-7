package lotto.model;

import java.util.List;

public class Money {

    private static final int PRICE_MINIMUM = 1;
    private final int price;

    public Money(int price) {
        this.price = price;
    }

    public boolean isOutOfRange(int minimum, int maximum) {
        return price < minimum || price > maximum;
    }

    public boolean isIndivisibleBy(int ticketPrice) {
        return price % ticketPrice != 0;
    }

    public boolean isPurchasable(List<Lotto> lottos, int ticketPrice) {
        return lottos.size() < price / ticketPrice;
    }
}
