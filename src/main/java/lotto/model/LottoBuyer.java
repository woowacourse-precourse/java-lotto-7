package lotto.model;


import lotto.message.ErrorMessage;

import java.util.LinkedList;
import java.util.List;

public class LottoBuyer {
    private static final int PAYMENT_LIMIT = 100000;
    private static final int PAYMENT_UNIT = 1000;

    private final List<Lotto> lottos;
    private Integer id;
    private Integer payment;

    public LottoBuyer(String payment) {
        validatePayment(payment);
        lottos = new LinkedList<>();
        this.payment = parsePayment(payment);
    }

    private void validatePayment(String payment) {
        checkBlank(payment);
        checkNumeric(payment);
        checkLimit(payment);
    }

    private void checkBlank(String payment) {
        if (payment.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_EMPTY.getMessage());
        }
    }

    private void checkNumeric(String payment) {
        if (!payment.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_NOT_A_NUMBER.getMessage());
        }
    }

    private void checkLimit(String payment) {
        int amount = Integer.parseInt(payment);
        if (amount > PAYMENT_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_LIMIT_EXCEEDED.getMessage());
        }
    }

    private Integer parsePayment(String payment) {
        int amount = Integer.parseInt(payment);
        if (amount % PAYMENT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_INVALID_AMOUNT.getMessage());
        }
        return amount;
    }

    public Integer getPayment() {
        return payment;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
