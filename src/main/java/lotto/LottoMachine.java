package lotto;

import lotto.amount.Amount;
import lotto.lotto.Number;
import lotto.lotto.WinningNumbers;
import lotto.lotto.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.requestPurchaseAmount();
        Amount purchaseAmount = inputView.getPurchaseAmount();

        int lottoCount = purchaseAmount.calculateLottoCount();
        outputView.printPurchaseLottoNumbers(lottoCount);

        outputView.requestWinningNumbers();
        WinningNumbers winningNumbers = inputView.getWinningNumbers();

        outputView.requestBonusNumber();
        Number bonusNumber = inputView.getBonusNumber();

        WinningResult winningResult =
                new WinningResult(winningNumbers, bonusNumber);

        outputView.printWinningStatistics(winningResult);
    }
}
