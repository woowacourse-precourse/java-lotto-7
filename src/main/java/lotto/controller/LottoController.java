package lotto.controller;

import java.util.function.Function;
import lotto.controller.model.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = getInput(OutputView::printPurChaseAmountInputMessage, PurchaseAmount::from);
    }

    private <T> T getInput(Runnable outputMessage, Function<String, T> parser) {
        while (true) {
            try {
                outputMessage.run();
                String input = InputView.readInput();
                return parser.apply(input);
            } catch (RuntimeException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
