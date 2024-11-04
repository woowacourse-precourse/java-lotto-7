package lotto.config;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputProvider;
import lotto.view.InputProvider;
import lotto.view.LottoInputViewFactory;
import lotto.view.winningLottoView.WinningLottoOutputViewFactory;

public class AppConfig {

    private InputProvider inputProvider() {
        return new ConsoleInputProvider();
    }

    private WinningLottoOutputViewFactory outputViewFactory() {
        return new WinningLottoOutputViewFactory();
    }

    private LottoInputViewFactory inputViewFactory() {
        return new LottoInputViewFactory();
    }

    public LottoController createLottoController() {
        return new LottoController(inputProvider(), inputViewFactory(), outputViewFactory());
    }
}
