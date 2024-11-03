package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoRateCalculator {

    public double calculateRateOfReturn(List<PrizeType> prizes, int initCash) {
        int totalPrizeMoney = 0;

        for (PrizeType prize : prizes) {
            if (prize != null) {
                totalPrizeMoney += prize.getPrizeAmount();
            }
        }

        return calculateRoundedNum(totalPrizeMoney, initCash);
    }

    private double calculateRoundedNum(int totalPrizeMoney, int initCash){
        double yield = ((double) totalPrizeMoney / initCash) * 100;

        BigDecimal roundedYield = new BigDecimal(yield).setScale(2, RoundingMode.HALF_UP);
        return roundedYield.doubleValue();
    }
}
