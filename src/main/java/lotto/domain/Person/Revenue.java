package lotto.domain.Person;

import java.math.BigInteger;

public class Revenue {

    private Money initialInvestment;
    private Money totalEarnings;

    public Revenue(Money initialInvestment, Money totalEarnings) {
        this.initialInvestment = initialInvestment;
        this.totalEarnings = totalEarnings;
        validateDivisibleByThousand();
    }

    public double calculateReturnRate() {
        return totalEarnings.calculateReturnRate(initialInvestment);
    }

    private void validateDivisibleByThousand() {
        if (initialInvestment.getAmount().mod(BigInteger.valueOf(1000)).compareTo(BigInteger.ZERO) != 0) {
            throw new IllegalArgumentException("금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }
    
}
