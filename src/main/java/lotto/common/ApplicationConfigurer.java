package lotto.common;

import lotto.controller.DrawController;
import lotto.controller.PurchaseController;
import lotto.domain.LottoFactory;
import lotto.endpoint.input.ConsoleInputView;
import lotto.endpoint.input.InputView;
import lotto.endpoint.output.ConsoleOutputView;
import lotto.endpoint.output.OutputView;

public class ApplicationConfigurer {
    public static InputView getInputView() {
        return new ConsoleInputView();
    }

    public static OutputView getOutputView() {
        return new ConsoleOutputView();
    }

    public static DrawController getDrawController() {
        return new DrawController();
    }

    public static PurchaseController getPurchaseController() {
        return new PurchaseController(new LottoFactory());
    }
}
