package lotto;

import java.util.function.Supplier;
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

        WinningResult winningResult = generateWinningResult(winningNumbers);
        printWinningResult(winningResult, lottos, purchaseAmount);
    }

    private Amount getPurchaseAmount() {
        return retry(() -> {
            outputView.requestPurchaseAmount();
            return inputView.getPurchaseAmount();
        });
    }

    private Lottos getLottos(Amount purchaseAmount) {
        return retry(() -> {
            int lottoCount = purchaseAmount.calculateLottoCount();
            Lottos lottos = new Lottos(lottoCount);
            outputView.printPurchaseLottoNumbers(lottos);
            return lottos;
        });
    }

    private WinningNumbers getWinningNumbers() {
        return retry(() -> {
            outputView.requestWinningNumbers();
            return inputView.getWinningNumbers();
        });
    }

    private Number getBonusNumber(WinningNumbers winningNumbers) {
        return retry(() -> {
            outputView.requestBonusNumber();
            Number bonusNumber = inputView.getBonusNumber();
            winningNumbers.containsNumber(bonusNumber);
            return bonusNumber;
        });
    }

    private WinningResult generateWinningResult(WinningNumbers winningNumbers) {
        return retry(() -> {
            Number bonusNumber = getBonusNumber(winningNumbers);

            return new WinningResult(winningNumbers, bonusNumber);
        });
    }

    private void printWinningResult(WinningResult winningResult, Lottos lottos, Amount purchaseAmount) {
        winningResult.calculateResult(lottos);
        outputView.printWinningStatistics(winningResult, purchaseAmount);
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
