package lotto.model.draw;

public class Payment {
    private final int payment;

    public Payment(final String payment) {
        validate(payment);
        this.payment = Integer.parseInt(payment);
    }

    private void validate(final String payment) {
        // TODO 예외 처리
    }

    public int getPayment() {
        return payment;
    }
}
