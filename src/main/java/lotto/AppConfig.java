package lotto;

import lotto.handler.LottoCheckController;
import lotto.handler.LottoGenerateController;
import lotto.handler.LottoResultController;
import lotto.handler.RandomValueGenerator;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public InputView inputView() {
        return new InputView(inputValidator());
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoGenerateController lottoGenerateController() {
        return new LottoGenerateController(randomValueGenerator(), inputView(), outputView());
    }

    public RandomValueGenerator randomValueGenerator() {
        return new RandomValueGenerator();
    }

    public LottoCheckController lottoCheckController() {
        return new LottoCheckController(inputView(), outputView());
    }

    public LottoResultController lottoResultController() {
        return new LottoResultController(outputView());
    }
}
