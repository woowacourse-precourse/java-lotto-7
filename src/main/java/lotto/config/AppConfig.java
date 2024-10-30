package lotto.config;

import lotto.domain.LottoManager;
import lotto.utils.InputParser;
import lotto.utils.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public InputView getInputView() {
        return new InputView(getInputParser());
    }

    public InputParser getInputParser() {
        return new InputParser(new InputValidator());
    }

    public OutputView getOutputView() {
        return new OutputView();
    }

    public LottoManager getLottoManager() {
        return new LottoManager();
    }
}
