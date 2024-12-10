package lotto.config;

import lotto.controller.LottoGameController;
import lotto.io.input.GameInput;
import lotto.io.input.impl.InputConsole;
import lotto.io.output.GameOutput;
import lotto.io.output.impl.OutputConsole;
import lotto.service.LottoService;

public class LottoGameAppConfig {
    public LottoGameController lottoGame() {
        return new LottoGameController(input(), output(), lottoService());
    }

    public GameInput input() {
        return new InputConsole();
    }

    public GameOutput output() {
        return new OutputConsole();
    }

    public LottoService lottoService() {
        return new LottoService();
    }
}
