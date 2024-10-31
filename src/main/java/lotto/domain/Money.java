package lotto.domain;

import lotto.common.NumberConstants;

public class Money {

    private final long money;

    public Money(String rawMoney) {
        String trimMoney = trim(rawMoney);
        validateBlank(trimMoney);
        validateNumber(trimMoney);
        long money = Long.parseLong(trimMoney);
        validateThousandUnit(money);
        this.money = money;
    }

    private String trim(String money) {
        return money.trim();
    }

    private void validateBlank(String money) {
        if (isBlank(money)) {
            throw new IllegalArgumentException("구입 금액은 공백일 수 없습니다.");
        }
    }

    private void validateNumber(String money) {
        if (isPositive(money))
            return;
        throw new IllegalArgumentException("구입 금액은 양수여야 합니다.");

    }

    private void validateThousandUnit(long money) {
        if (isDivisibleBy(NumberConstants.LOTTO_COST, money))
            return;
        throw new IllegalArgumentException("구입 금액은 1000 단위여야 합니다.");
    }

    private boolean isPositive(String money) {
        return money.matches("\\d+");
    }

    private boolean isBlank(String money) {
        return money == null || money.isEmpty();
    }

    private boolean isDivisibleBy(long divisor, Long money) {
        return money / divisor != 0;
    }

    public long getMoney() {
        return this.money;
    }

}
