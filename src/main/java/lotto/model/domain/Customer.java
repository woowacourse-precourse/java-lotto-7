package lotto.model.domain;

import static lotto.message.ErrorMessage.INVALID_PAYMENT_AMOUNT;
import static lotto.message.ErrorMessage.INVALID_PAYMENT_FORMAT;
import static lotto.message.ErrorMessage.INVALID_PAYMENT_LIMIT;
import static lotto.message.ErrorMessage.PAYMENT_IS_BLANK;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final List<Lotto> lottos;
    private Integer id;
    private Integer payment;

    public Customer(String payment) {
        validatePayment(payment);
        this.payment = parsePayment(payment);
        lottos = new ArrayList<>();
    }

    private void validatePayment(String payment) {
        checkBlank(payment);
        checkNumeric(payment);
        checkLimit(payment);
    }

    private void checkBlank(String payment) {
        if (payment.isBlank()) {
            throw new IllegalArgumentException(PAYMENT_IS_BLANK.getMessage());
        }
    }

    private void checkNumeric(String payment) {
        if (!payment.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_PAYMENT_FORMAT.getMessage());
        }
    }

    private void checkLimit(String payment) {
        int amount = Integer.parseInt(payment);
        if (amount > 100000) {
            throw new IllegalArgumentException(INVALID_PAYMENT_LIMIT.getMessage());
        }
    }

    private Integer parsePayment(String payment) {
        int amount = Integer.parseInt(payment);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT_AMOUNT.getMessage());
        }
        return amount;
    }

    public Integer getId() {
        return id;
    }

    public void updateId(Integer id) {
        this.id = id;
    }

    public Integer getPayment() {
        return payment;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
