package lotto.customer;

import static lotto.validation.Validation.validatePayAmount;

public class Customer {

    private final int payAmount;

    public Customer(int payAmount) {
        validatePayAmount(payAmount);
        this.payAmount = payAmount;
    }
}
