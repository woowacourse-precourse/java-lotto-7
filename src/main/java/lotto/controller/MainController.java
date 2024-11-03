package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;

public class MainController {
    private final InputController inputController;
    private final LottoController lottoController;
    private final OutputController outputController;

    private MainController() {
        inputController = InputController.getInstance();
        lottoController = LottoController.getInstance();
        outputController = OutputController.getInstance();
    }

    private static class SingletonHelper {
        private static final MainController INSTANCE = new MainController();
    }

    public static MainController getInstance() {
        return MainController.SingletonHelper.INSTANCE;
    }


    public void run() {
        outputController.showDescription();

        int purchaseAmount = inputController.inputPurchaseAmount();
        Lottos lottos = lottoController.purchaseLottos(purchaseAmount);
        outputController.outputLottos(lottos);

        Lotto targetLotto = inputController.inputLotto();
        int bonusNumber = inputController.inputBonus(targetLotto);

        Result winningResult = lottoController.winningResult(lottos, targetLotto, bonusNumber);
        outputController.outputResult(winningResult, purchaseAmount);
    }
}
