package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoStatistic;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import lotto.service.GameStatisticService;
import lotto.service.LottoPurchaseService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LottoGameController {
    private final LottoPurchaseService lottoPurchaseService;
    private final WinningNumberService winningNumberService;
    private final GameStatisticService gameStatisticService;
    private final OutputView outputView;

    public LottoGameController(LottoPurchaseService lottoPurchaseService, WinningNumberService winningNumberService,
                               GameStatisticService gameStatisticService, OutputView outputView) {
        this.lottoPurchaseService = lottoPurchaseService;
        this.winningNumberService = winningNumberService;
        this.gameStatisticService = gameStatisticService;
        this.outputView = outputView;
    }

    public void start() {
        LottoTicket lottoTicket = purchaseLottoTicketWithRetry();
        outputView.printLottoTickets(lottoTicket);

        Lotto winningLotto = createWinningLottoWithRetry();
        WinningNumbers winningNumbers = createWinningNumbersWithRetry(winningLotto);

        LottoStatistic result = gameStatisticService.calculateLottoResult(lottoTicket, winningNumbers);
        outputView.printLottoStatistics(result);
    }

    private LottoTicket purchaseLottoTicketWithRetry() {
        return retryWhileValid(() -> {
            OutputView.requestLotteryPurchaseAmount();
            String purchase = InputView.requestTotalAmount();
            return lottoPurchaseService.purchaseLotto(purchase);
        });
    }

    private Lotto createWinningLottoWithRetry() {
        return retryWhileValid(() -> {
            OutputView.requestLotteryWinningNumber();
            String numbers = InputView.requestWinningNumber();
            return winningNumberService.createWinningLotto(numbers);
        });
    }

    private WinningNumbers createWinningNumbersWithRetry(Lotto winningNumbers) {
        return retryWhileValid(() -> {
            OutputView.requestLotteryBonusNumber();
            String number = InputView.requestBonusNumber();
            int bonusNumber = winningNumberService.createBonusNumber(number);
            return winningNumberService.createWinningNumbers(winningNumbers, bonusNumber);
        });
    }

    private <T> T retryWhileValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

}
