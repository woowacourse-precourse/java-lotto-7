package lotto.config;

import lotto.view.InputView;
import lotto.view.OutputView;

public class ViewConfig {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static InputView getInputView() {
        return inputView;
    }

    public static OutputView getOutputView() {
        return outputView;
    }
}
