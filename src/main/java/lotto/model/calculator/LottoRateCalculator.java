package lotto.model.calculator;

import java.util.List;

public class LottoRateCalculator {

    private double rate;

    public void calculate(int price, List<Integer> lottoResult) {
        long totalPrize = 0;

        totalPrize += lottoResult.get(0) * Prize.FIRST.get();
        totalPrize += lottoResult.get(1) * Prize.SECOND.get();
        totalPrize += lottoResult.get(2) * Prize.THIRD.get();
        totalPrize += lottoResult.get(3) * Prize.FOURTH.get();
        totalPrize += lottoResult.get(4) * Prize.FIFTH.get();

        rate = ((double) totalPrize / price) * 100;

        halfUp();
    }

    private void halfUp() {
        rate = Math.round(rate * 10.0) / 10.0;
    }

    public double getRate() {
        return rate;
    }
}
