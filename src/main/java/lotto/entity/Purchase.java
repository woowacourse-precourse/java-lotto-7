package lotto.entity;

import lotto.configuration.LottoConfiguration;
import lotto.validator.PurchaseValidator;

public class Purchase {
    private final int paymentAmount;

    public Purchase(int paymentAmount) {
        PurchaseValidator.validate(paymentAmount);
        this.paymentAmount = paymentAmount;
    }

    public int calculateTicketCount() {
        return paymentAmount / LottoConfiguration.LOTTO_PRICE.getValue();
    }


    public int getPaymentAmount() {
        return paymentAmount;
    }

}
