package lotto.presentation.controller;


import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumbers;
import lotto.domain.model.PrizeCategory;
import lotto.domain.service.LottoPurchaseService;
import lotto.domain.service.LottoStatisticsService;
import java.util.List;
import lotto.presentation.view.LottoOutputView;
import lotto.presentation.view.LottoInputView;


//로또 게임을 제어하는 클래스
public class LottoController {
    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();
    private final LottoPurchaseService purchaseService = new LottoPurchaseService();
    private final LottoStatisticsService statisticsService = new LottoStatisticsService();

    public void run() {
        int purchaseAmount = getValidPurchaseAmount();

        List<Lotto> tickets = purchaseService.purchaseTickets(purchaseAmount);
        outputView.displayPurchasedTickets(tickets);

        WinningNumbers winningNumbers = getValidWinningNumbers();

        int[] prizeCounts = statisticsService.calculatePrizeCounts(tickets, winningNumbers);
        int totalPrize = statisticsService.calculateTotalPrize(prizeCounts);
        double profitRate = statisticsService.calculateProfitRate(purchaseAmount, totalPrize);

        outputView.displayWinningStatistics(List.of(PrizeCategory.values()), prizeCounts);
        outputView.displayTotalProfitRate(profitRate);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                return inputView.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers getValidWinningNumbers() {
        while (true) {
            try {
                return inputView.getWinningNumbers();
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}