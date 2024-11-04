package lotto.config;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputProvider;
import lotto.view.InputProvider;
import lotto.view.lottoWinningView.LottoWinningOutputViewFactory;

public class AppConfig {

    public InputProvider inputProvider() {
        return new ConsoleInputProvider();
    }

    public LottoWinningOutputViewFactory outputViewFactory() {
        return new LottoWinningOutputViewFactory();
    }

    public LottoController createLottoController() {
        return new LottoController(inputProvider(), outputViewFactory());
    }
}
