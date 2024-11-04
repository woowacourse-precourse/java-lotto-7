package lotto;

import lotto.controller.LottoController;
import lotto.handler.RetryHandler;
import lotto.service.LottoPurchaseService;
import lotto.service.StatisticService;
import lotto.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        StatisticService statisticService = new StatisticService();
        RetryHandler retryHandler = new RetryHandler();

        LottoController lottoController = new LottoController(inputView, outputView, lottoPurchaseService, winningNumbersService, statisticService, retryHandler);
        lottoController.run();
    }
}
