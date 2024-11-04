package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.util.Validator;
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
            // 구입 금액을 입력
            String input = InputView.getPurcahseAmount();
            Validator.purchaseAmount(input);
            int amount = Validator.parseInt(input);

            // 로또 구매
            List<Lotto> userLottos = lottoService.purchase(amount);
            OutputView.printPurchase(userLottos);

            // 당첨 번호 및 보너스 번호 입력
            WinningLotto winningLotto = winningLottoController.getWinningLotto();

            // 결과 출력
            resultController.displayResult(userLottos, winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
