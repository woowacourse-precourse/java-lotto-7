package lotto.domain;

import java.util.List;

public class ResultLotto {

    private static final double ROUNDING_SCALE = 10.0;
    private static final double PROFIT_PERCENTAGE_SCALE = 100.0;

    private final List<LottoRank> ranks;
    private final long purchaseMoney;


    public ResultLotto(List<LottoRank> ranks, long purchaseMoney) {
        this.ranks = ranks;
        this.purchaseMoney = purchaseMoney;
    }

    public double getProfitPercent() {
        return roundToScale(calculateProfitMargin() * PROFIT_PERCENTAGE_SCALE);
    }

    private double roundToScale(double value) {
        return Math.round(value * ROUNDING_SCALE) / ROUNDING_SCALE;
    }

    private double calculateProfitMargin() {
        return getTotalPrizeMoney() / purchaseMoney;
    }

    private double getTotalPrizeMoney() {
        return ranks.stream()
                .mapToDouble(LottoRank::getPrizeMoney)
                .sum();
    }
}
