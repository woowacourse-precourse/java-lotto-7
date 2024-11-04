package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.service.LottoGameService;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoGameService lottoGameService = new LottoGameService();

    public void run() {
        LottoPurchase lottoPurchase = lottoGameService.inputPurchaseAmount();
        List<Lotto> purchasedLotto = lottoGameService.generateLottoTickets(lottoPurchase);
        OutputView.printPurchasedLotto(purchasedLotto);
        List<Integer> winningNumbers = lottoGameService.inputWinningNumbers();
    }
}
