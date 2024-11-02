package lotto.model;

import java.util.List;

public class Amount {
    private final int amount;
    private static final String REQUEST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String NOT_DIVISIBLE_BY_THOUSAND_ERROR = "[ERROR] 로또의 금액이 1000원 단위가 아닙니다.";
    private final int amountDivisor = 1000;

    public Amount(int amountInput) {
        isDivideByThousand(amountInput);
        this.amount = amountInput;
    }

    public boolean isDivideByThousand(int amountInput) {
        if (amountInput % amountDivisor == 0) {
            return true;
        }
        throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND_ERROR);
    }

    public int getAmount() {
        return this.amount;
    }

    public static String getRequestMessage() {
        return REQUEST_AMOUNT_MESSAGE;
    }

    public int getPublishCount() {
        return this.amount/amountDivisor;
    }
}
