package lotto.entity;

import lotto.configuration.LottoConfiguration;
import lotto.validator.PurchaseValidator;

public class PaymentAmount {
    private final int amount;

    public PaymentAmount(int paymentAmount) {
        PurchaseValidator.validate(paymentAmount);
        this.amount = paymentAmount;
    }

    public int calculateTicketCount() {
        return amount / LottoConfiguration.LOTTO_PRICE.getValue();
    }

    public int getAmount() {
        return amount;
    }

}
