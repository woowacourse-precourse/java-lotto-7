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

public class LottoGameFactory {
    private LottoGameFactory() {

    }

    public static LottoGameController createGame() {
        return new LottoGameController(
                createLottoPurchaseService(),
                createWinningNumberService(),
                createGameStatisticService(),
                createOutputView()
        );

    }

    private static LottoPurchaseService createLottoPurchaseService() {
        return new LottoPurchaseService(new AmountValidator(), new LottoMachine());
    }

    private static WinningNumberService createWinningNumberService() {
        return new WinningNumberService(new LottoValidator(), new BonusValidator());
    }

    private static GameStatisticService createGameStatisticService() {
        return new GameStatisticService();
    }

    private static OutputView createOutputView() {
        return new OutputView();
    }
}
