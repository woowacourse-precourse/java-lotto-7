package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Result;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class OutputController {
    private final OutputView outputView;
    private final LottoService lottoService;

    private OutputController() {
        outputView = OutputView.getInstance();
        lottoService = LottoService.getInstance();
    }


    private static class SingletonHelper {
        private static final OutputController INSTANCE = new OutputController();
    }

    public static OutputController getInstance() {
        return OutputController.SingletonHelper.INSTANCE;
    }


    public void showDescription() {
        outputView.showDescription();
    }

    public void outputLottos(Lottos lottos) {
        String lottosString = lottoService.lottosString(lottos);

        outputView.outputLottos(lottosString);
    }

    public void outputResult(Result winningResult, int purchaseAmount) {
        String resultString = lottoService.resultString(winningResult, purchaseAmount);

        outputView.outputResult(resultString);
    }
}
