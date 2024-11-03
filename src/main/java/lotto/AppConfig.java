package lotto;

import lotto.controller.Controller;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class AppConfig {
    public Input input() {
        return new Input();
    }

    public Output output() {
        return new Output();
    }

    public LottoService lottoService() {
        return new LottoService();
    }

    public Controller controller() {
        return new Controller(input(), output(), lottoService());
    }
}
