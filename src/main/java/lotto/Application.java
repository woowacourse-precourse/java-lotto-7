package lotto;

import lotto.controller.LottoController;
import lotto.model.Cashier;
import lotto.model.LottoManager;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoResult lottoResult = new LottoResult();
        Cashier cashier = new Cashier();

        LottoController lottoController = new LottoController(inputView, outputView, lottoManager, lottoResult, cashier);
        lottoController.run();
    }
}
