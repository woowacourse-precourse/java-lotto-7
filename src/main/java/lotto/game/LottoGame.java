package lotto.game;

import lotto.dto.BuyingPrice;
import lotto.dto.WinningNumbers;
import lotto.io.OutputHandler;

public class LottoGame {
    private final BuyingPrice buyingPrice;
    private final Lottos lottos;

    public LottoGame(BuyingPrice buyingPrice, Lottos lottos) {
        this.buyingPrice = buyingPrice;
        this.lottos = lottos;
    }

    public void start(WinningNumbers winningNumbers) {
        LottoPrizeRecord lottoPrizeRecord = lottos.checkLottos(winningNumbers);
        lottoPrizeRecord.printResult();
        int totalWinningPrice = lottoPrizeRecord.computeWinningPrice();

        computeYield(totalWinningPrice);
    }

    private void computeYield(int totalWinningPrice) {
        double yield = (double) totalWinningPrice / buyingPrice.getPrice();
        OutputHandler.printYield(yield);
    }
}
