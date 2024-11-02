package lotto.config;

import lotto.controller.LottoInputController;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class ApplicationConfig {

    public static InputView inputView = getInputView();
    public static OutputView outputView = getOutputView();
    public static LottoInputController lottoInputController = getInputController();

    private ApplicationConfig() {
    }

    static InputView getInputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    static OutputView getOutputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    static LottoInputController getInputController() {
        if (lottoInputController == null) {
            lottoInputController = new LottoInputController(getInputView());
        }
        return lottoInputController;
    }
}
