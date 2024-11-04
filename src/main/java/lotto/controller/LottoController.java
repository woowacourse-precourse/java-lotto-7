package lotto.controller;

import lotto.domain.Lotto;
import java.util.List;
import java.util.Map;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        int totalSpent = InputView.promptPurchaseAmount();
        List<Lotto> tickets = lottoService.purchaseLottoTickets(totalSpent);
        OutputView.printPurchasedTickets(tickets);

        List<Integer> jackpotNumbers = InputView.promptWinningNumbers();
        int bonusNumber = InputView.promptBonusNumber(jackpotNumbers);

        Map<String, Integer> resultCounts = lottoService.checkWinnings(tickets, jackpotNumbers, bonusNumber);
        double roi = lottoService.calculateROI(totalSpent, resultCounts.get("totalPrize"));
        OutputView.printResults(resultCounts, roi);
    }
}
