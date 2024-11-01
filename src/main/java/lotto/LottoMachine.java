package lotto;

import lotto.amount.Amount;
import lotto.lotto.Lottos;
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
        Amount purchaseAmount = getPurchaseAmount();

        Lottos lottos = getLottos(purchaseAmount);

        WinningNumbers winningNumbers = getWinningNumbers();

        Number bonusNumber = getBonusNumber();

        WinningResult winningResult = new WinningResult(winningNumbers, bonusNumber);
        winningResult.calculateResult(lottos);

        outputView.printWinningStatistics(winningResult);
    }

    private Amount getPurchaseAmount() {
        outputView.requestPurchaseAmount();
        return inputView.getPurchaseAmount();
    }

    private Lottos getLottos(Amount purchaseAmount) {
        int lottoCount = purchaseAmount.calculateLottoCount();
        Lottos lottos = new Lottos(lottoCount);
        outputView.printPurchaseLottoNumbers(lottos);
        return lottos;
    }

    private WinningNumbers getWinningNumbers() {
        outputView.requestWinningNumbers();
        return inputView.getWinningNumbers();
    }

    private Number getBonusNumber() {
        outputView.requestBonusNumber();
        return inputView.getBonusNumber();
    }
}
