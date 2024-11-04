package lotto.config;

import lotto.controller.LottoRetypingController;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class ApplicationConfig {

    public static InputView inputView = getInputView();
    public static OutputView outputView = getOutputView();
    public static LottoRetypingController lottoRetypingController = getRetypingController();

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

    static LottoRetypingController getRetypingController() {
        if (lottoRetypingController == null) {
            lottoRetypingController = new LottoRetypingController(getInputView());
        }
        return lottoRetypingController;
    }
}
