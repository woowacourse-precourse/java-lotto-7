package lotto.model.payment;

import static lotto.common.Constants.*;

public class Payment {
    private static final int MAX_PURCHASE_LIMIT = 100000;
    private static final String MAX_PURCHASE_LIMIT_EXCEEDED = ERROR_HEADER + "로또 최대 구입 금액은 100,000원 입니다.";
    private static final String INVALID_PURCHASE_AMOUNT = ERROR_HEADER + "로또 구입 금액은 1,000원 단위여야 합니다.";

    private final int payment;

    private Payment(int payment) {
        validate(payment);
        this.payment = payment;
    }

    public static Payment from(String input) {
        try {
            return new Payment(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public int get() {
        return this.payment;
    }

    private void validate(int payment) {
        if(payment > MAX_PURCHASE_LIMIT) {
            throw new IllegalArgumentException(MAX_PURCHASE_LIMIT_EXCEEDED);
        }
        if (payment == 0 || payment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }
}
