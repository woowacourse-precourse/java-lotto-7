package lotto.config;

import lotto.Validator;
import lotto.model.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public Validator validator() {
        return new Validator();
    }

    public InputView inputView() {
        return new InputView(validator());
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoManager lottoManager() {
        return new LottoManager();
    }
}
