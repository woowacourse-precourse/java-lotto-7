package lotto.entity;

import lotto.configuration.LottoConfiguration;
import lotto.exception.LottoValidationException;
import lotto.exception.PurchaseExceptionMessage;

public class Purchase {
    private final int amount;

    public Purchase(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int calculateTicketCount() {
        return amount / LottoConfiguration.LOTTO_PRICE.getValue();
    }


    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount < LottoConfiguration.LOTTO_PRICE.getValue()) {
            throw new LottoValidationException(PurchaseExceptionMessage.AMOUNT_LESS_THAN_PRICE);
        }
        if (amount % LottoConfiguration.LOTTO_PRICE.getValue() != 0) {
            throw new LottoValidationException(PurchaseExceptionMessage.AMOUNT_NOT_MULTIPLE_OF_PRICE);
        }
        if (amount > LottoConfiguration.PURCHASE_LIMIT.getValue()) {
            throw new LottoValidationException(PurchaseExceptionMessage.AMOUNT_EXCEEDS_LIMIT);
        }
    }

}
