package lotto.config;

import lotto.controller.LottoController;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.InputViewFactory;
import lotto.view.LottoPurchasesView;
import lotto.view.OutputView;

public class Config {

    private Config() {
    }

    public static LottoController createLottoController() {
        return new LottoController(inputView(), outputView(), lottoService());
    }

    private static OutputView outputView() {
        return new LottoPurchasesView(null);
    }

    private static InputView inputView() {
        return InputViewFactory.createInputViewOf(InputViewFactory.AMOUNT);
    }

    private static LottoService lottoService() {
        return new LottoService();
    }
}
