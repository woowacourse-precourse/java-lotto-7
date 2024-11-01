package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoMachine(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        final PurchaseAmount purchaseAmount = inputPurchaseAmount();
        final Lottos lottos = lottoGenerator.generateLottos(purchaseAmount.getQuantity());
        outputView.printLottos(lottos.get());

        final WinningNumbers winningNumbers = inputWinningNumbers();
        inputBonusNumber(winningNumbers);
        final WinningResult winningResult = lottos.getWinningResult(winningNumbers);
        outputView.printWinningResult(winningResult.get());

        final double profitRate = winningResult.calculateProfitRate(purchaseAmount.get());
        outputView.printProfitRate(profitRate);
    }

    private PurchaseAmount inputPurchaseAmount() {
        while (true) {
            try {
                return inputView.readPurchaseAmount();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                return inputView.readWinningNumbers();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void inputBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                int number = inputView.readBonusNumber();
                winningNumbers.setBonusNumber(number);
                return;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
