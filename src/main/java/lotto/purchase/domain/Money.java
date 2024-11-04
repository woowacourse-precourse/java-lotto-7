package lotto.purchase.domain;

import lotto.common.NumberConstants;
import lotto.checker.domain.NumberImpl;

import static lotto.common.ErrorMessage.ERROR_MESSAGE;
import static lotto.common.NumberConstants.ZERO;

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
        throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 1000 단위여야 합니다.");
    }

    private boolean isDivisibleBy(Long money) {
        return money % NumberConstants.LOTTO_COST == ZERO;
    }

    public long value() {
        return this.money;
    }

    @Override
    public String getDomain() {
        return "입력금액";
    }

}
