package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Rank;
import lotto.service.LottoResultService;
import lotto.service.LottoGameService;
import lotto.view.PurchaseOutputView;
import lotto.view.StatisticOutputView;

public class LottoGameController {
    private final LottoGameService lottoGameService = new LottoGameService();
    private final LottoResultService lottoResultService = new LottoResultService();

    public void run() {
        LottoPurchase lottoPurchase = lottoGameService.inputPurchaseAmount();
        List<Lotto> purchasedLottos = lottoGameService.generateLottoTickets(lottoPurchase);
        PurchaseOutputView.printPurchasedLotto(purchasedLottos);

        List<Integer> winningNumbers = lottoGameService.inputWinningNumbers();
        int bonusNumber = lottoGameService.inputBonusNumber(winningNumbers);

        Map<Rank, Integer> results = lottoResultService.calculateResults(purchasedLottos, winningNumbers, bonusNumber);
        double profitRate = lottoResultService.calculateProfitRate(results, lottoPurchase.getAmount());

        printWinResults(results, profitRate);
    }

    private void printWinResults(Map<Rank, Integer> results, double profitRate) {
        StatisticOutputView.printLottoResults(results);
        StatisticOutputView.printProfitRate(profitRate);
    }
}
