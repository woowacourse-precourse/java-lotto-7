package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.enums.LottoRank;

public class LottoResult {
    private final Map<LottoRank, Integer> result;
    private final int totalPrize;
    private final double profitRate;

    public LottoResult(List<Lotto> lottos, LottoPrize lottoPrize, int purchaseAmount) {
        this.result = calculateLottoResult(lottos, lottoPrize);
        this.totalPrize = calculateTotalPrize();
        this.profitRate = calculateProfitRate(purchaseAmount);
    }

    private Map<LottoRank, Integer> calculateLottoResult(List<Lotto> lottos, LottoPrize lottoPrize) {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = calculateRank(lotto, lottoPrize);
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
        }
        return result;
    }

    private LottoRank calculateRank(Lotto lotto, LottoPrize lottoPrize) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(lottoPrize.getLotto().getNumbers()::contains)
                .count();
        boolean secondBonus = lotto.getNumbers().contains(lottoPrize.getBonusNumber());
        return LottoRank.getLottoRank(matchCount, secondBonus);
    }

    private int calculateTotalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateProfitRate(int purchaseAmount) {
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0;
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
