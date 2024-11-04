package lotto.controller;

import lotto.handler.RetryHandler;
import lotto.model.LottoStatistics;
import lotto.model.LottoTickets;
import lotto.model.WinningNumbers;
import lotto.service.LottoPurchaseService;
import lotto.service.StatisticService;
import lotto.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseService lottoPurchaseService;
    private final WinningNumbersService winningNumbersService;
    private final StatisticService statisticService;
    private final RetryHandler retryHandler;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           LottoPurchaseService lottoPurchaseService,
                           WinningNumbersService winningNumbersService,
                           StatisticService statisticService,
                           RetryHandler retryHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoPurchaseService = lottoPurchaseService;
        this.winningNumbersService = winningNumbersService;
        this.statisticService = statisticService;
        this.retryHandler = retryHandler;
    }

    public void run() {
        LottoTickets lottoTickets = retryHandler.getInputUntilValid(this::purchaseLotto);
        WinningNumbers winningNumbers = retryHandler.getInputUntilValid(this::getWinningNumbers);
        calculateProfit(lottoTickets, winningNumbers);
    }

    private LottoTickets purchaseLotto() {
        outputView.printInputPurchaseAmount();

        int purchaseAmount = inputView.getPurchaseAmount();
        LottoTickets lottoTickets = lottoPurchaseService.purchaseLotto(purchaseAmount);

        outputView.printOutputLottoCount(lottoTickets.getLottoCount());
        outputView.printOutputLottoNumbers(lottoTickets.getLottos());
        return lottoTickets;
    }

    private WinningNumbers getWinningNumbers() {
        List<Integer> winningNumber = retryHandler.getInputUntilValid(this::getWinningNumbersOnly);
        int bonusNumber = retryHandler.getInputUntilValid(() -> getBonusNumber(winningNumber));
        return winningNumbersService.generateWinningNumbers(winningNumber, bonusNumber);
    }

    private List<Integer> getWinningNumbersOnly() {
        outputView.printInputWinnerNumber();
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        winningNumbersService.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        outputView.printInputBonusNumber();
        int bonusNumber = inputView.getBonusNumber();
        winningNumbersService.validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private void calculateProfit(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        LottoStatistics lottoStatistics = statisticService.calculateStatistics(lottoTickets.getLottos(), winningNumbers);
        outputView.printOutputLottoStatistics(lottoStatistics.getResultMap());
        double profit = statisticService.calculateProfit(lottoStatistics, lottoTickets.getPurchaseAmount());
        outputView.printOutputProfit(profit);
    }
}
