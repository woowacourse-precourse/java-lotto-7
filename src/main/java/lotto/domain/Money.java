package lotto.domain;

import lotto.common.NumberConstants;

public class Money extends NumberImpl {

    private final long money;

    public Money(String rawMoney) {
        String trimMoney = rawMoney.trim();
        validateBlank(trimMoney, getDomain());
        validateNumber(trimMoney, getDomain());
        long money = Long.parseLong(trimMoney);
        validateThousandUnit(money);
        this.money = money;
    }

    private void validateThousandUnit(long money) {
        if (isDivisibleBy(money))
            return;
        throw new IllegalArgumentException("구입 금액은 1000 단위여야 합니다.");
    }

    private boolean isDivisibleBy(Long money) {
        return money / NumberConstants.LOTTO_COST != 0;
    }

    public long value() {
        return this.money;
    }

    @Override
    String getDomain() {
        return "입력금액";
    }

}
