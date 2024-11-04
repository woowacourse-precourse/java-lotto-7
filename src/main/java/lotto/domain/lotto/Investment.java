package lotto.domain.lotto;

import static lotto.common.exception.ErrorMessage.INVESTMENT_MUST_BE_DIVISIBLE_BY_THOUSAND;
import static lotto.common.exception.ErrorMessage.INVESTMENT_MUST_BE_GREATER_THAN_ZERO;
import static lotto.common.exception.ErrorMessage.INVESTMENT_MUST_BE_LESS_THAN_OR_EQUAL_ONE_HUNDRED_THOUSAND;

import java.math.BigInteger;
import lotto.common.exception.LottoException;

public class Investment {

    private final BigInteger initialInvestment;

    public Investment(BigInteger initialInvestment) {
        this.initialInvestment = initialInvestment;
        validateDivisibleByThousand();
        validateGreaterThanZero();
        validateLessThanOneHundredThousand();
    }

    public int getQuantity() {
        return initialInvestment.divide(BigInteger.valueOf(1000)).intValue();
    }

    private void validateGreaterThanZero() {
        if (initialInvestment.compareTo(BigInteger.ZERO) < 0) {
            throw new LottoException(INVESTMENT_MUST_BE_GREATER_THAN_ZERO);
        }
    }

    private void validateDivisibleByThousand() {
        if (initialInvestment.mod(BigInteger.valueOf(1000)).compareTo(BigInteger.ZERO) != 0) {
            throw new LottoException(INVESTMENT_MUST_BE_DIVISIBLE_BY_THOUSAND);
        }
    }

    private void validateLessThanOneHundredThousand() {
        if (initialInvestment.compareTo(BigInteger.valueOf(100000)) > 0) {
            throw new LottoException(INVESTMENT_MUST_BE_LESS_THAN_OR_EQUAL_ONE_HUNDRED_THOUSAND);
        }
    }

    public BigInteger getAmount() {
        return initialInvestment;
    }
}
