package lotto.io;

import lotto.model.Lotto;
import lotto.model.WinningResult;

import java.util.List;

public class LottoIOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public int askPurchaseAmount() {
        outputHandler.showPurchaseAmountInstruction();
        return inputHandler.inputPurchaseAmount();
    }

    public void showPurchasedLottos(List<Lotto> lottos) {
        outputHandler.showLottos(lottos);
    }

    public String askWinningNumbers() {
        outputHandler.showWinningNumbersInstruction();
        return inputHandler.getWinningNumbers().value();
    }

    public int askBonusNumber() {
        outputHandler.showBonusNumberInstruction();
        return inputHandler.getBonusNumber();
    }

    public void showWinningStatistics(WinningResult result) {
        outputHandler.showWinningStatisticsComment();
        outputHandler.showWinningResult(result);
        outputHandler.showTotalPrize(result);
    }

}
