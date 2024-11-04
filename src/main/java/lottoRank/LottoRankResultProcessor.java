package lottoRank;

import calculate.LottoPrizeCalculator;

public class LottoRankResultProcessor {
    private final LottoRankStore rankStore = new LottoRankStore();
    private final LottoRankStatisticsPrinter statisticsPrinter = new LottoRankStatisticsPrinter();
    private final LottoPrizeCalculator prizeCalculator = new LottoPrizeCalculator();

    public void store(int lottoNumberMatch, boolean isMatchBonusNumber) {
        rankStore.store(lottoNumberMatch, isMatchBonusNumber);
    }

    public void printStatistics() {
        statisticsPrinter.print(rankStore.getResults());
    }

    public long calculateTotalPrize() {
        return prizeCalculator.calculateTotalPrize(rankStore.getResults());
    }
}
