package lotto.lottoMachine.lottoRank;

import lotto.calculateManager.LottoPrizeManager;

public class LottoRankResultProcessor {
    private final LottoRankStore rankStore = new LottoRankStore();
    private final LottoRankStatisticsPrinter statisticsPrinter = new LottoRankStatisticsPrinter();

    public void store(int lottoNumberMatch, boolean isMatchBonusNumber) {
        rankStore.store(lottoNumberMatch, isMatchBonusNumber);
    }

    public void printStatistics() {
        statisticsPrinter.print(rankStore.getResults());
    }

    public long calculateTotalPrize() {
        LottoPrizeManager lottoPrizeManager = new LottoPrizeManager(rankStore.getResults());

        return lottoPrizeManager.getTotalPrize();
    }
}
