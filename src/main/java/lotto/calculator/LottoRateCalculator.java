package lotto.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoRateCalculator {

    private static final long FIRST_PRIZE = 2000000000;
    private static final long SECOND_PRIZE = 30000000;
    private static final long THIRD_PRIZE = 1500000;
    private static final long FOURTH_PRIZE = 50000;
    private static final long FIFTH_PRIZE = 5000;

    private double rate;

    public void calculate(int price, List<Integer> lottoResult) {
        long totalPrize = 0;

        totalPrize += lottoResult.get(0) * FIRST_PRIZE;
        totalPrize += lottoResult.get(1) * SECOND_PRIZE;
        totalPrize += lottoResult.get(2) * THIRD_PRIZE;
        totalPrize += lottoResult.get(3) * FOURTH_PRIZE;
        totalPrize += lottoResult.get(4) * FIFTH_PRIZE;
        rate = (double) totalPrize / price;

        halfUp();
    }

    private void halfUp() {
        rate = Math.round(rate * 100.0) / 100.0;
    }

    public double getRate() {
        return rate;
    }
}
