package lotto.controller;

import lotto.model.*;
import lotto.service.*;
import lotto.util.InputValidator;
import lotto.view.*;

import java.util.List;

public class LottoController {
    private final InputController inputController;
    private final OutputController outputController;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView,
                           InputValidator inputValidator, LottoFactory lottoFactory) {
        this.inputController = new InputController(inputView, inputValidator);
        this.outputController = new OutputController(outputView);
        this.lottoService = new LottoService(lottoFactory);
    }

    public void run() {
        try {
            Money money = inputController.getMoney();
            List<Lotto> lottos = lottoService.createLottos(money);
            outputController.printLottoPurchaseInfo(lottos);

            WinningInfo winningInfo = inputController.getWinningInfo();
            LottoResult result = lottoService.calculateResult(lottos, winningInfo);
            outputController.printGameResult(result);

            double profit = lottoService.calculateProfit(result, money);
            outputController.printProfit(profit);

        } catch (IllegalStateException e) {
            outputController.printError(e.getMessage());
        }
    }
}