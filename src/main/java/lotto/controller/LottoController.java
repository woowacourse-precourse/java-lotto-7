package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final WinningLottoController winningLottoController;
    private final ResultController resultController;

    public LottoController(LottoService lottoService, WinningLottoController winningLottoController, ResultController resultController) {
        this.lottoService = lottoService;
        this.winningLottoController = winningLottoController;
        this.resultController = resultController;
    }

    public void run() {
        try {
            // 구입 금액을 입력 받고 로또 구매
            int amount = InputView.getPurcahseAmount();
            List<Lotto> userLottos = lottoService.purchase(amount);
            OutputView.printPurchase(userLottos);

            WinningLotto winningLotto = winningLottoController.getWinningLotto();
            resultController.displayResult(userLottos, winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
