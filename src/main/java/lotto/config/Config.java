package lotto.config;

import lotto.controller.LottoController;
import lotto.model.service.LottoResultService;
import lotto.model.service.MyLottosGenerateService;
import lotto.view.InputView;
import lotto.view.InputViewFactory;
import lotto.view.LottoPurchasesView;
import lotto.view.OutputView;

public class Config {

    private Config() {
    }

    public static LottoController createLottoController() {
        return new LottoController(inputView(), outputView(), lottoGenerateService(), lottoResultService());
    }

    private static OutputView outputView() {
        return new LottoPurchasesView(null);
    }

    private static InputView inputView() {
        return InputViewFactory.createInputView(InputViewFactory.AMOUNT);
    }

    private static MyLottosGenerateService lottoGenerateService() {
        return new MyLottosGenerateService();
    }

    private static LottoResultService lottoResultService() {
        return new LottoResultService();
    }
}
