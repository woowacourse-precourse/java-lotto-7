package lotto;

import static lotto.Constants.*;

public class Payment {
    private static final int MAX_PURCHASE_LIMIT = 100000;
    private static final String MAX_PURCHASE_LIMIT_EXCEEDED = ERROR_HEADER + "로또 최대 구입 금액은 100,000원 입니다.";
    private static final String INVALID_PURCHASE_AMOUNT = ERROR_HEADER + "로또 구입 금액은 1,000원 단위여야 합니다.";

    private final int value;

    private Payment(int value) {
        validate(value);
        this.value = value;
    }

    public static Payment from(String input) {
        try {
            return new Payment(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public int getValue() {
        return this.value;
    }

    private void validate(int value) {
        if(value > MAX_PURCHASE_LIMIT) {
            throw new IllegalArgumentException(MAX_PURCHASE_LIMIT_EXCEEDED);
        }
        if (value == 0 || value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }
}
