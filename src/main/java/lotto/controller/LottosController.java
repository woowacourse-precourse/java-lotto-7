package lotto.controller;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottosController {
    public void run() {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            LottoService lottoService = new LottoService();
            lottoService.purchaseLottos(purchaseAmount);
            OutputView.printPurchasedLottos(lottoService.getPurchasedLottos());

            WinningNumbers winningNumbers = inputWinningNumbers();

            Map<LottoRank, Integer> results = lottoService.calculateResults(winningNumbers);
            int totalPrize = lottoService.calculateTotalPrize(results);
            double yield = lottoService.calculateYield(purchaseAmount, totalPrize);

            OutputView.printResults(results, yield);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }
}
