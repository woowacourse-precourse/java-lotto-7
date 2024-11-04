package lotto.service;

import lotto.domain.LottoMatch;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.LottoRank;

public class LottoProfitService {

    private static final double ROUNDING_SCALE = 10.0;
    private static final double PROFIT_PERCENTAGE_SCALE = 100.0;

    public double calculateProfitPercent(LottoMatch lottoMatch, LottoPurchaseMoney lottoPurchaseMoney) {
        double profitMargin = getProfitMargin(lottoMatch, lottoPurchaseMoney);

        return roundToScale(profitMargin);
    }

    public double getTotalPrizeMoney(LottoMatch lottoMatch) {
        return lottoMatch.getRanks().stream()
                .mapToDouble(LottoRank::getPrizeMoney)
                .sum();
    }

    public double getProfitMargin(LottoMatch lottoMatch, LottoPurchaseMoney lottoPurchaseMoney) {
        return getTotalPrizeMoney(lottoMatch) / lottoPurchaseMoney.getMoney() * PROFIT_PERCENTAGE_SCALE;
    }

    public double roundToScale(double value) {
        return Math.round(value * ROUNDING_SCALE) / ROUNDING_SCALE;
    }
}
