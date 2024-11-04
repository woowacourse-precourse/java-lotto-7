package lotto.controller;

import lotto.domain.Lotto;
import java.util.List;
import java.util.Map;
import lotto.service.LotteryService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    public void start() {
        int totalSpent = InputView.promptPurchaseAmount();
        List<Lotto> tickets = lotteryService.purchaseLottoTickets(totalSpent);
        OutputView.printPurchasedTickets(tickets);

        List<Integer> jackpotNumbers = InputView.promptWinningNumbers();
        int bonusNumber = InputView.promptBonusNumber(jackpotNumbers);

        Map<String, Integer> resultCounts = lotteryService.checkWinnings(tickets, jackpotNumbers, bonusNumber);
        double roi = lotteryService.calculateROI(totalSpent, resultCounts.get("totalPrize"));
        OutputView.printResults(resultCounts, roi);
    }
}
