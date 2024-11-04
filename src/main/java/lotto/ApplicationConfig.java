package lotto;

import lotto.model.LottoIssuer;
import lotto.model.LottoNumbersGenerator;
import lotto.io.InputHandler;
import lotto.io.InputView;
import lotto.io.OutputView;

public class ApplicationConfig {

    public InputHandler inputHandler() {
        return new InputHandler(inputView());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoIssuer lottoIssuer() {
        return new LottoIssuer(lottoNumbersGenerator());
    }

    public LottoNumbersGenerator lottoNumbersGenerator() {
        return new LottoNumbersGenerator();
    }
}
