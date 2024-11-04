package lotto.controller;

import java.util.List;
import lotto.dto.LottoPurchase;
import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.service.LottoGameService;
import lotto.service.LottoResultService;
import lotto.view.PurchaseOutputView;
import lotto.view.StatisticOutputView;

public class LottoGameController {
    private final LottoGameService lottoGameService = new LottoGameService();
    private final LottoResultService lottoResultService = new LottoResultService();

    private static void printWinResults(LottoResult lottoResult) {
        StatisticOutputView.printLottoResults(lottoResult.rankResults());
        StatisticOutputView.printProfitRate(lottoResult.profitRate());
    }

    public void run() {
        LottoPurchase lottoPurchase = lottoGameService.inputPurchaseAmount();
        List<Lotto> purchasedLottos = lottoGameService.generateLottoTickets(lottoPurchase);
        PurchaseOutputView.printPurchasedLotto(purchasedLottos);

        List<Integer> winningNumbers = lottoGameService.inputWinningNumbers();
        int bonusNumber = lottoGameService.inputBonusNumber(winningNumbers);

        LottoResult lottoResult = lottoResultService.calculateLottoResult(purchasedLottos, winningNumbers, bonusNumber,
                lottoPurchase);

        printWinResults(lottoResult);
    }
}
