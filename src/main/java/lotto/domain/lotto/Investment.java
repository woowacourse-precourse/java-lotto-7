package lotto.domain.lotto;

import java.math.BigInteger;

public class Investment {

    private final BigInteger initialInvestment;

    public Investment(BigInteger initialInvestment) {
        this.initialInvestment = initialInvestment;
        validateDivisibleByThousand();
        validGreaterThanZero();
    }

    public int getQuantity() {
        return initialInvestment.divide(BigInteger.valueOf(1000)).intValue();
    }

    private void validGreaterThanZero() {
        if (initialInvestment.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("금액은 0 이상이어야 합니다.");
        }
    }

    private void validateDivisibleByThousand() {
        if (initialInvestment.mod(BigInteger.valueOf(1000)).compareTo(BigInteger.ZERO) != 0) {
            throw new IllegalArgumentException("금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public BigInteger getAmount() {
        return initialInvestment;
    }
}
