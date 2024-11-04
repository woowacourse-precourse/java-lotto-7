package lotto.validator;

import java.math.BigInteger;
import lotto.exception.MoneyErrorCode;

public class MoneyValidator {
    private static final int MIN_MONEY = 0;
    private static final int MAX_MONEY = Integer.MAX_VALUE;

    public void validateNumeric(String money) {
        try{
            BigInteger moneyAmount = new BigInteger(money);
            validateRangeMax(moneyAmount);
            validateRangeMin(moneyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MoneyErrorCode.MONEY_PARSE_ERROR.getMessage());
        }
    }

    private void validateRangeMax(BigInteger money) {
        if (money.compareTo(BigInteger.valueOf(MAX_MONEY)) > 0) {
            throw new IllegalArgumentException(MoneyErrorCode.MONEY_MAX_ERROR.getMessage());
        }
    }

    private void validateRangeMin(BigInteger money) {
        if (money.compareTo(BigInteger.valueOf(MIN_MONEY)) <= 0) {
            throw new IllegalArgumentException(MoneyErrorCode.MONEY_MIN_ERROR.getMessage());
        }
    }

    public void validateDivideWithLottoPrice(int money, int lottoPrice) {
        if (!isDividable(money, lottoPrice)) {
            throw new IllegalArgumentException(MoneyErrorCode.MONEY_DIVIDE_ERROR.getMessage());
        }
    }

    private boolean isDividable(int money, int lottoPrice) {
        return money % lottoPrice == 0;
    }
}
