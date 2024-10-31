package lotto;

import lotto.model.LottoIssuer;
import lotto.model.LottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationConfig {

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
