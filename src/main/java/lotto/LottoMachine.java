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

        LottoStatistics winningStatistics = calculateWinningStatistics(lottoPool, winningLotto, bonusNumber);
        lottoIOHandler.showWinningStatistics(winningStatistics, purchaseAmount);
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

    private LottoStatistics calculateWinningStatistics(LottoPool lottoPool, Lotto winningLotto, int bonusNumber) {
        LottoStatistics lottoStatistics = new LottoStatistics();

        for (Lotto userLotto : lottoPool) {
            LottoRank lottoRank = LottoRank.checkWinningRank(userLotto, winningLotto, bonusNumber);
            incrementWinningCountIfLottoRankIsNotNull(lottoRank, lottoStatistics);
        }

        return lottoStatistics;
    }

    private void incrementWinningCountIfLottoRankIsNotNull(LottoRank lottoRank, LottoStatistics lottoStatistics) {
        if (lottoRank != null) {
            lottoStatistics.incrementWinningCount(lottoRank);
        }
    }
}
