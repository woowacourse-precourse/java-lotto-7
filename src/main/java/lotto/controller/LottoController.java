package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.application.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void start() {
        try {
            int purchaseAmount = InputView.getPurchaseAmount();
            List<Lotto> tickets = LottoService.generateTickets(purchaseAmount);
            OutputView.printPurchasedTickets(tickets);

            Lotto winningLotto = InputView.getWinningNumbers();
            int bonusNumber = InputView.getBonusNumber();

            Map<LottoResult, Integer> results = LottoService.calculateResults(tickets, winningLotto, bonusNumber);
            OutputView.printResults(results, purchaseAmount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage("[ERROR]");
        }
    }
}

