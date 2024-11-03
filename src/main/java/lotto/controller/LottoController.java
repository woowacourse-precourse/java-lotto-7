package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.MatchLevel;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController() {
        this.lottoView = new LottoView();
        this.lottoService = new LottoService();
    }

    public void run() {
        long purchaseAmount = lottoView.getPurchaseAmount();
        int purchaseCount = (int) (purchaseAmount / 1000);
        List<Lotto> lottos = lottoService.generateLottos(purchaseCount);

        lottoView.displayPurchasedLottos(lottos);

        List<Integer> winningNumbers = lottoView.getWinningNumbers();
        int bonusNumber = lottoView.getBonusNumber(winningNumbers);

        Map<MatchLevel, Integer> result = lottoService.caculateMatchLevel(lottos, winningNumbers, bonusNumber);
        double profit = lottoService.calculateProfit(result, purchaseAmount);

        lottoView.displayResult(result);
        lottoView.displayProfit(profit);
    }


}
