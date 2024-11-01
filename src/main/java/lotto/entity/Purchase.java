package lotto.entity;

import lotto.configuration.LottoConfiguration;
import lotto.exception.LottoValidationException;
import lotto.exception.PurchaseExceptionMessage;

public class Purchase {
    private final int paymentAmount;

    public Purchase(int paymentAmount) {
        validate(paymentAmount);
        this.paymentAmount = paymentAmount;
    }

    public int calculateTicketCount() {
        return paymentAmount / LottoConfiguration.LOTTO_PRICE.getValue();
    }


    public int getPaymentAmount() {
        return paymentAmount;
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
