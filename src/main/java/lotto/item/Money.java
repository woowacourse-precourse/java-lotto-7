package lotto.item;

import lotto.constant.ErrorName;

public class Money {
    private final int money;

    public Money(String moneyBeforeValid) {
        validate(moneyBeforeValid);
        this.money = Integer.parseInt(moneyBeforeValid);
    }

    public int getMoneyValue() {
        return money;
    }

    private void validate(String moneyBeforeValid) {
        if (moneyBeforeValid == null) {
            throw new IllegalArgumentException(ErrorName.ErrorNoValue.getErrorMessage());
        }

        try {
            Integer.parseInt(moneyBeforeValid);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorName.ErrorNotNumber.getErrorMessage());
        }

        if (Integer.parseInt(moneyBeforeValid) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorName.ErrorThousand.getErrorMessage());
        }
    }
}