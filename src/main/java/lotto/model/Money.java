package lotto.model;

import static lotto.constants.LottoConfig.PRICE_MAXIMUM;
import static lotto.constants.LottoConfig.PRICE_MINIMUM;
import static lotto.constants.LottoConfig.TICKET_PRICE;

import java.util.List;
import lotto.constants.ExceptionMessage;

public class Money {

    private final int price;

    public Money(int price) {
        validate(price);
        this.price = price;
    }

    public void validate(int price) {
        if (isOutOfRange(price)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_OUT_OF_RANGE_PRICE.getMessage());
        }
        if (isIndivisible(price)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_INDIVISIBLE_PRICE.getMessage());
        }
    }

    private boolean isOutOfRange(int price) {
        return price < PRICE_MINIMUM || price > PRICE_MAXIMUM;
    }

    private boolean isIndivisible(int price) {
        return price % TICKET_PRICE != 0;
    }

    public boolean isPurchasable(List<Lotto> lottos) {
        return lottos.size() < price / TICKET_PRICE;
    }

    public int getPrice() {
        return price;
    }
}
