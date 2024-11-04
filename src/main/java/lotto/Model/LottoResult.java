package lotto.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = ranks.stream().mapToInt(Rank::getPrize).sum();
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return roundToTwoDecimalPlaces(profitRate);
    }

    private double roundToTwoDecimalPlaces(double value) {
        return BigDecimal.valueOf(value)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
