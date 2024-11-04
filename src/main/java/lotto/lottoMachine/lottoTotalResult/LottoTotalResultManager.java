package lotto.lottoMachine.lottoTotalResult;

import lotto.LottoResultStore;
import lotto.lottoMachine.calculateManager.LottoPrizeManager;

public class LottoTotalResultManager {
    private final LottoResultStore rankStore = new LottoResultStore();
    private final LottoTotalResultStatisticsPrinter statisticsPrinter = new LottoTotalResultStatisticsPrinter();

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
