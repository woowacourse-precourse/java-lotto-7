package lotto.view;
import lotto.dto.LottoResponse;
import lotto.dto.PrizeResponse;

import java.util.List;
import java.util.function.Supplier;

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

    public int readPurchaseAmountInput() {
        return readInput(outputView::promptPurchaseAmount, inputView::readPurchaseAmountInput);
    }

    public String readWinningLottoNumbersInput() {
        return readInput(outputView::promptLottoNumbers, inputView::readLottoNumbersInput);
    }

    public int readBonusNumberInput() {
        return readInput(outputView::promptBonusNumber, inputView::readBonusNumberInput);
    }

    public void printPurchasableLottoCount(int lottoCount) {
        outputView.printPurchasableLottoCount(lottoCount);
    }

    public void printPurchasedLottos(List<LottoResponse> lottoResponses) {
        outputView.printPurchasedLottos(lottoResponses);
    }

    public void printWinningResult(List<PrizeResponse> prizeResponses) {
        outputView.printWinningResult(prizeResponses);
    }

    public void printProfitRate(double profitRate) {
        outputView.printProfitRate(profitRate);
    }

    private <T> T readInput(Runnable prompt, Supplier<T> inputSupplier) {
        try {
            prompt.run();
            return inputSupplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return readInput(prompt, inputSupplier);
        }
    }
}
