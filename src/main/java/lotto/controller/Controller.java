package lotto.controller;

import lotto.domain.buyer.Buyer;
import lotto.domain.number.Number;
import lotto.domain.number.Numbers;
import lotto.domain.winning.WinningInfo;
import lotto.domain.winning.WinningStatistics;
import lotto.service.LottoNumberService;
import lotto.service.LottoService;
import lotto.service.WinningStatisticsService;
import lotto.view.InputView;

public class Controller {
    private final InputView inputView;
    private final LottoService lottoService;
    private final LottoNumberService lottoNumberService;
    private final WinningStatisticsService winningStatisticsService;

    public Controller(final InputView inputView, final LottoService lottoService,
                      final LottoNumberService lottoNumberService,
                      final WinningStatisticsService winningStatisticsService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
        this.lottoNumberService = lottoNumberService;
        this.winningStatisticsService = winningStatisticsService;
    }

    public void run() {
        Buyer buyer = purchaseLotto();
        WinningInfo winningInfo = inputWinningNumbers();
        WinningStatistics winningStatistics = calculateStatistics(buyer, winningInfo);
        displayStatistics(winningStatistics);
    }

    private Buyer purchaseLotto() {
        String inputMoney = inputView.inputMoney();
        Buyer buyer = lottoService.createBuyer(inputMoney);
        System.out.println(buyer.getbuyLottos().toString());
        return buyer;
    }

    private WinningInfo inputWinningNumbers() {
        String inputWinningNumbers = inputView.inputWinningNumbers();
        Numbers winningNumbers = lottoNumberService.createWinningNumbers(inputWinningNumbers);

        Number bonus = inputBonusNumber(inputWinningNumbers);

        return WinningInfo.of(winningNumbers, bonus);
    }

    private Number inputBonusNumber(String inputWinningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                return lottoNumberService.createBonusNumber(inputBonusNumber, inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningStatistics calculateStatistics(final Buyer buyer, final WinningInfo winningInfo) {
        return winningStatisticsService.calculateWinningStatistics(buyer, winningInfo);
    }

    private void displayStatistics(WinningStatistics winningStatistics) {
        System.out.println(winningStatistics.toString());
    }
}
