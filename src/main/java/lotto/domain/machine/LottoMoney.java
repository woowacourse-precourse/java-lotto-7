package lotto.domain.machine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.exception.GlobalException.MoneyException;
import lotto.exception.message.LottoMoneyExceptionMessage;

public class LottoMoney {

    private static final BigDecimal LOTTO_MONEY_UNIT = BigDecimal.valueOf(1_000);
    private static final BigDecimal MAX_LOTTO_MONEY = LOTTO_MONEY_UNIT.multiply(BigDecimal.valueOf(Integer.MAX_VALUE));
    private static final int DIVIDE_SCALE = 4;
    private static final int FIX_SCALE = 1;
    private final BigDecimal money;

    protected LottoMoney(BigDecimal money) {
        this.money = money;
    }

    public static LottoMoney from(BigDecimal money) {
        validateLottoMoneyAmount(money);
        validateLottoMoneyUnit(money);
        validateMaxLottoMoney(money);
        return new LottoMoney(money);
    }

    private static void validateLottoMoneyUnit(BigDecimal money) {
        if (isNotLottoMoneyUnit(money)) {
            throw new MoneyException(LottoMoneyExceptionMessage.INVALID_MONEY_UNIT);
        }
    }

    private static boolean isNotLottoMoneyUnit(BigDecimal money) {
        return !money.remainder(LOTTO_MONEY_UNIT).equals(BigDecimal.ZERO);
    }

    private static void validateLottoMoneyAmount(BigDecimal money) {
        if (money.compareTo(LOTTO_MONEY_UNIT) < 0) {
            throw new MoneyException(LottoMoneyExceptionMessage.INVALID_MONEY_AMOUNT);
        }
    }

    private static void validateMaxLottoMoney(BigDecimal money) {
        if (money.compareTo(MAX_LOTTO_MONEY) > 0) {
            throw new MoneyException(LottoMoneyExceptionMessage.INVALID_MAX_MONEY);
        }
    }

    public int getDrawCount() {
        return money.divide(LOTTO_MONEY_UNIT, RoundingMode.DOWN).intValue();
    }

    public BigDecimal getProfitRate(BigDecimal totalPrize) {
        return totalPrize.divide(money, DIVIDE_SCALE, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(FIX_SCALE, RoundingMode.HALF_UP);
    }

}
