package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Rank;
import lotto.service.HitNumberCalculator;
import lotto.service.LottoGameService;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoGameService lottoGameService = new LottoGameService();
    private final HitNumberCalculator hitNumberCalculator = new HitNumberCalculator();

    public void run() {
        LottoPurchase lottoPurchase = lottoGameService.inputPurchaseAmount();
        List<Lotto> purchasedLottos = lottoGameService.generateLottoTickets(lottoPurchase);

        OutputView.printPurchasedLotto(purchasedLottos);

        List<Integer> winningNumbers = lottoGameService.inputWinningNumbers();
        int bonusNumber = lottoGameService.inputBonusNumber(winningNumbers);

        Map<Rank, Integer> results = hitNumberCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printLottoResults(results);
    }
}
