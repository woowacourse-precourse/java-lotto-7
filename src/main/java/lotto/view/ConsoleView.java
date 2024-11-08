package lotto.view;

import lotto.dto.PurchasedLottosResponse;
import lotto.dto.WinningSummaryResponse;

public class ConsoleView {
    private final InputView inputView;
    private final OutputView outputView;

    private ConsoleView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private static class ConsoleViewHolder {
        private static final ConsoleView CONSOLE_VIEW = new ConsoleView(
                InputView.getInstance(),
                OutputView.getInstance()
        );
    }

    public static ConsoleView getInstance() {
        return ConsoleViewHolder.CONSOLE_VIEW;
    }

    public String readPurchaseAmountInput() {
        outputView.promptPurchaseAmount();

        return inputView.readInput();
    }

    public String readWinningLottoNumbersInput() {
        outputView.promptLottoNumbers();

        return inputView.readInput();
    }

    public String readBonusNumberInput() {
        outputView.promptBonusNumber();

        return inputView.readInput();
    }

    public void closeRead() {
        inputView.closeRead();
    }

    public void printPurchasableLottoCount(int lottoCount) {
        outputView.printPurchasableLottoCount(lottoCount);
    }

    public void printPurchasedLottos(PurchasedLottosResponse purchasedLottos) {
        outputView.printPurchasedLottos(purchasedLottos);
    }

    public void printWinningResult(WinningSummaryResponse winningSummary) {
        outputView.printWinningResult(winningSummary);
    }

    public void printException(Exception exception) {
        outputView.printException(exception);
    }
}
