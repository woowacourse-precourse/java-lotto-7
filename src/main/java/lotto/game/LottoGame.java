package lotto.game;

import lotto.dto.BuyingPrice;
import lotto.dto.Buyer;
import lotto.io.OutputHandler;

public class LottoGame {
    private final BuyingPrice buyingPrice;
    private final Lottos lottos;

    public LottoGame(BuyingPrice buyingPrice, Lottos lottos) {
        this.buyingPrice = buyingPrice;
        this.lottos = lottos;
    }

    public void start(Buyer buyer) {
        LottoPrizeRecord lottoPrizeRecord = lottos.checkLottos(buyer);
        lottoPrizeRecord.printResult();
        int totalWinningPrice = lottoPrizeRecord.computeWinningPrice();

        computeYield(totalWinningPrice);
    }

    private void computeYield(int totalWinningPrice) {
        double yield = (double) totalWinningPrice / buyingPrice.getPrice();
        OutputHandler.printYield(yield);
    }
}
