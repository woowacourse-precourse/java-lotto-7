package lotto.config;

import lotto.utils.InputValidator;
import lotto.view.InputView;

public class AppConfig {

    public InputView getInputView() {
        return new InputView(new InputValidator());
    }
}
