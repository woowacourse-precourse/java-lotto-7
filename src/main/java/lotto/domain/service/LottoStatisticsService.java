package lotto.domain.service;

import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumbers;
import lotto.domain.model.PrizeCategory;
import java.util.List;

public class LottoStatisticsService {
    private final LottoPrizeService prizeService;

    public LottoStatisticsService() {
        this.prizeService = new LottoPrizeService();
    }

    public int[] calculatePrizeCounts(List<Lotto> tickets, WinningNumbers winningNumbers) {
        int[] prizeCounts = new int[PrizeCategory.values().length];

        for (Lotto ticket : tickets) {
            PrizeCategory prize = prizeService.calculatePrize(ticket, winningNumbers);
            if (prize != null) {
                prizeCounts[prize.ordinal()]++;
            }
        }
        return prizeCounts;
    }

    public int calculateTotalPrize(int[] prizeCounts) {
        int totalPrize = 0;
        for (PrizeCategory category : PrizeCategory.values()) {
            totalPrize += prizeCounts[category.ordinal()] * category.getPrize();
        }
        return totalPrize;
    }

    public double calculateProfitRate(int purchaseAmount, int totalPrize) {
        return Math.round(((double) totalPrize / purchaseAmount) * 1000) / 10.0;
    }
}