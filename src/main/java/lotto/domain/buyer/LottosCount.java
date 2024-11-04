package lotto.domain.buyer;

import static lotto.resources.Constants.THOUSAND_UNIT;
import static lotto.resources.ErrorMessages.INVALID_THOUSAND_UNIT_MONEY;
import static lotto.resources.ErrorMessages.NEGATIVE_QUANTITY_MONEY;

import java.util.Objects;

public class LottosCount {
    private final int LottosCount;

    private LottosCount(final int money) {
        validateMoney(money);
        this.LottosCount = money / THOUSAND_UNIT;
    }

    public static LottosCount from(final int money) {
        return new LottosCount(money);
    }

    private void validateMoney(final int money) {
        validatePositiveMoney(money);
        validateThousandUnitMoney(money);
    }

    private void validatePositiveMoney(final int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_QUANTITY_MONEY.getMessage());
        }
    }

    private void validateThousandUnitMoney(final int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_THOUSAND_UNIT_MONEY.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final LottosCount otherLottosCount = (LottosCount) obj;
        return Objects.equals(LottosCount, otherLottosCount.LottosCount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(LottosCount);
    }

    public int getLottosCount() {
        return LottosCount;
    }
}
