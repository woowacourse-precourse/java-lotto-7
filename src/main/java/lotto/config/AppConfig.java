package lotto.config;

import lotto.controller.InputController;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class AppConfig {

    public static InputView inputView = getInputView();
    public static OutputView outputView = getOutputView();
    public static InputController inputController = getInputController();

    private AppConfig() {
    }

    private static InputView getInputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private static OutputView getOutputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private static InputController getInputController() {
        if (inputController == null) {
            inputController = new InputController(getInputView());
        }
        return inputController;
    }
}
