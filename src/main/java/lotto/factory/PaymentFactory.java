package lotto.factory;

import lotto.domain.Wallet;
import lotto.service.Payment;

public class PaymentFactory {

    public static Payment create(Wallet wallet) {
        return new Payment(wallet);
    }
}
