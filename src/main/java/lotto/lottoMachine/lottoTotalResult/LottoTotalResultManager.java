package lotto.lottoMachine.lottoTotalResult;

import lotto.LottoResultStore;
import lotto.lottoMachine.calculateManager.LottoPrizeManager;

public class LottoTotalResultManager {
    private final LottoResultStore resultStore = new LottoResultStore();
    private final LottoTotalResultStatisticsPrinter statisticsPrinter = new LottoTotalResultStatisticsPrinter();

    public void store(int lottoNumberMatch, boolean isMatchBonusNumber) {
        resultStore.store(lottoNumberMatch, isMatchBonusNumber);
    }

    public void printStatistics() {
        statisticsPrinter.print(resultStore.getResults());
    }

    public long calculateTotalPrize() {
        LottoPrizeManager lottoPrizeManager = new LottoPrizeManager(resultStore.getResults());

        return lottoPrizeManager.getTotalPrize();
    }
}
