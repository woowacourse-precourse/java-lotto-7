package lotto.model;

import lotto.dto.PurchaseMoneyRequest;

public class Money {
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;
    private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 구입금액은 1,000원 단위이어야 합니다.";

    private static final int STANDARD_UNIT = 1000;
    private static final String INVALID_STANDARD_UNIT_MESSAGE = "[ERROR] 구입금액은 1,000 ~ 100,000까지 가능합니다.";

    private int money;

    public Money(PurchaseMoneyRequest request) {
        validate(request.getMoney());
        this.money = request.getMoney();
    }

    private void validate(int money) {
        validateRange(money);
        validateUnit(money);
    }

    private void validateRange(int money) {
        if (money < MIN_PURCHASE_AMOUNT || money > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    private void validateUnit(int money) {
        if (money % STANDARD_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_STANDARD_UNIT_MESSAGE);
        }
    }
}
