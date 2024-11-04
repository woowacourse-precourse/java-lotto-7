package lotto.model.payment;

import lotto.model.lotto.Lotto;

public class Payment {

    private long inputPayment;
    private final PaymentValidator paymentValidator = new PaymentValidator();

    public Payment(String inputPayment) {
        paymentValidator.validate(inputPayment);
        this.inputPayment = Long.parseLong(inputPayment);
    }

    public long calcLottoCount() {
        return inputPayment / Lotto.PRICE;
    }
}
