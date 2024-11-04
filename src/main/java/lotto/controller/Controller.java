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
        Buyer buyer = inputBuyerWithRepeat();
        System.out.println(buyer.getBuyerLottos().toString());
        return buyer;
    }

    private WinningInfo inputWinningNumbers() {
        Numbers winningNumbers = inputWinningNumbersWithRepeat();
        Number bonus = inputBonusNumberWithRepeat(winningNumbers);

        return WinningInfo.of(winningNumbers, bonus);
    }

    private Buyer inputBuyerWithRepeat() {
        while (true) {
            try {
                String inputMoney = inputView.inputMoney();
                return lottoService.createBuyer(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Numbers inputWinningNumbersWithRepeat() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.inputWinningNumbers();
                return lottoNumberService.createWinningNumbers(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Number inputBonusNumberWithRepeat(final Numbers inputWinningNumbers) {
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
