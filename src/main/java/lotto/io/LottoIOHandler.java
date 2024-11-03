package lotto.io;

import lotto.Lotto;
import lotto.LottoPool;
import lotto.LottoStatistics;

public class LottoIOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public int askLottoPurchaseAmount() {
        outputHandler.askLottoPurchaseAmount();
        return inputHandler.getLottoPurchaseAmount();
    }

    public void showLottoQuantity(int quantity) {
        outputHandler.showLottoQuantity(quantity);
    }

    public void showLottos(LottoPool lottoPool) {
        outputHandler.showLottos(lottoPool);
    }

    public Lotto askWinningNumbers() {
        outputHandler.askWinningNumbers();
        return inputHandler.getWinningNumbers();
    }

    public int askBonusNumber(Lotto winningLotto) {
        outputHandler.askBonusNumber();
        return inputHandler.getBonusNumber(winningLotto);
    }

    public void showWinningStatistics(LottoStatistics lottoStatistics, int purchaseAmount) {
        outputHandler.showWinningStatistics(lottoStatistics, purchaseAmount);
    }
}
