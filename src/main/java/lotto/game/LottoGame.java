package lotto.game;

import lotto.dto.WinningNumbers;
import lotto.io.OutputHandler;

public class LottoGame {
    private final int purchasePrice;
    private final Lottos lottos;

    public LottoGame(int purchasePrice, Lottos lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
    }

    public void start(WinningNumbers winningNumbers) {
        LottoPrizeRecord lottoPrizeRecord = lottos.checkLottos(winningNumbers);
        lottoPrizeRecord.printResult();
        int totalWinningPrice = lottoPrizeRecord.computeWinningPrice();

        computeYield(totalWinningPrice);
    }

    private void computeYield(int totalWinningPrice) {
        double yield = (double) totalWinningPrice / purchasePrice;
        OutputHandler.printYield(yield);
    }
}
