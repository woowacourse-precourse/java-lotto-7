package lotto.model;

import lotto.enums.LottoBoundInfo;
import lotto.enums.LottoPurchaseMoneyErrorMessage;

public class Money {
    private final int money;

    public Money(String rawInput) {
        validateIsNumber(rawInput);
        int money = Integer.parseInt(rawInput);

        validateIsPositive(money);
        validateIsMultipleOf1000(money);
        validateIsLessThanMaximum(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateIsNumber(String rawInput) {
        try {
            Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoPurchaseMoneyErrorMessage.NOT_INTEGER.getMessage());
        }
    }

    private void validateIsPositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(LottoPurchaseMoneyErrorMessage.NOT_POSITIVE.getMessage());
        }
    }

    private void validateIsMultipleOf1000(int money) {
        if (money % LottoBoundInfo.PRICE_PER_LOTTO.getInfo() != 0) {
            throw new IllegalArgumentException(LottoPurchaseMoneyErrorMessage.NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    private void validateIsLessThanMaximum(int money) {
        if (money > LottoBoundInfo.LOTTO_PURCHASE_MONEY_MAXIMUM.getInfo()) {
            throw new IllegalArgumentException(LottoPurchaseMoneyErrorMessage.OVER_1BILLION.getMessage());
        }
    }

}
