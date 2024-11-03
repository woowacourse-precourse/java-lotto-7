package lotto;

import lotto.io.LottoIOHandler;

public class LottoMachine {

    private final LottoIOHandler lottoIOHandler = new LottoIOHandler();

    public void run() {
        int purchaseAmount = lottoIOHandler.askLottoPurchaseAmount();

        int quantity = calculateQuantity(purchaseAmount);
        lottoIOHandler.showLottoQuantity(quantity);

        LottoPool lottoPool = generateLottoPool(quantity);
        lottoIOHandler.showLottos(lottoPool);

        Lotto winningLotto = lottoIOHandler.askWinningNumbers();
        int bonusNumber = lottoIOHandler.askBonusNumber(winningLotto);

    }

    private int calculateQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private LottoPool generateLottoPool(int quantity) {
        LottoPool lottoPool = new LottoPool();

        for (int i = 0; i < quantity; i++) {
            Lotto lotto = Lotto.generate();
            lottoPool.add(lotto);
        }

        return lottoPool;
    }
}
