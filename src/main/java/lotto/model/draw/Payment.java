package lotto.model.draw;

public class Payment {
    private final int payment;

    public Payment(final String payment) {
        validate(payment);
        this.payment = Integer.parseInt(payment);
    }

    private void validate(final String payment) {
//        validateInteger();
//        validtaeDivideByePrice();
    }

    public int getPayment() {
        return payment;
    }
}
