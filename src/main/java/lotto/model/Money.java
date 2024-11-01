package lotto.model;

import static lotto.constants.LottoConfig.PRICE_MAXIMUM;
import static lotto.constants.LottoConfig.TICKET_PRICE;

import java.util.List;

public class Money {

    private static final int PRICE_MINIMUM = 1;
    private final int price;

    public Money(int price) {
        this.price = price;
    }

    public boolean isOutOfRange() {
        return price < PRICE_MINIMUM || price > PRICE_MAXIMUM;
    }

    public boolean isIndivisibleBy() {
        return price % TICKET_PRICE != 0;
    }

    public boolean isPurchasable(List<Lotto> lottos) {
        return lottos.size() < price / TICKET_PRICE;
    }
}
