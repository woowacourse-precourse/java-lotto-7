package lotto.config;

import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Config {
    private final Validator validator = new Validator();
    private final InputView inputView = new InputView(validator);
    private final OutputView outputView = new OutputView();

    public Validator getValidator() {
        return validator;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

}
