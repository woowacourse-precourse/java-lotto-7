package lotto.domain.calculators;

public class YieldCalculator {

    public float calculate(long totalPrizeMoney, int amount) {
        return (float) totalPrizeMoney / amount * 100;
    }

}
