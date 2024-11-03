package lotto.factory;

import lotto.service.Payment;

public class PaymentFactory {

    public static Payment create(String money) {
        return new Payment(money);
    }
}
