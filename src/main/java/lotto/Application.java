package lotto;

import lotto.controller.LottoGameController;
import lotto.model.LottoMachine;
import lotto.service.GameStatisticService;
import lotto.service.LottoPurchaseService;
import lotto.service.WinningNumberService;
import lotto.validator.AmountValidator;
import lotto.validator.BonusValidator;
import lotto.validator.LottoValidator;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        WinningNumberService winningNumberService = new WinningNumberService(new LottoValidator(),new BonusValidator());
        GameStatisticService gameStatisticService = new GameStatisticService();
        OutputView outputView = new OutputView();
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(new AmountValidator(),new LottoMachine());
        LottoGameController lottoGameController = new LottoGameController(lottoPurchaseService,winningNumberService,
                gameStatisticService,outputView);

        lottoGameController.start();
    }
}
