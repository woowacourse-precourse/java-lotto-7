package lotto.config;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputProvider;
import lotto.view.InputProvider;
import lotto.view.winningLottoView.WinningLottoOutputViewFactory;

public class AppConfig {

    public InputProvider inputProvider() {
        return new ConsoleInputProvider();
    }

    public WinningLottoOutputViewFactory outputViewFactory() {
        return new WinningLottoOutputViewFactory();
    }

    public LottoController createLottoController() {
        return new LottoController(inputProvider(), outputViewFactory());
    }
}
