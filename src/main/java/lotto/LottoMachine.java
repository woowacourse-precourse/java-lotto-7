package lotto;

import lotto.io.LottoIOHandler;

public class LottoMachine {

    private final LottoIOHandler lottoIOHandler = new LottoIOHandler();

    public void run() {
        int purchaseAmount = lottoIOHandler.askLottoPurchaseAmount();
        int quantity = calculateQuantity(purchaseAmount);

        lottoIOHandler.showLottoQuantity(quantity);
    }

    private int calculateQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
