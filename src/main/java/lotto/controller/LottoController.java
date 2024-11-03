package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController(LottoService lottoService, LottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void run() {
        Money money = getMoneyFromUser();
        List<Lotto> purchasedLottos = lottoService.purchaseBy(money);
        lottoView.showPurchasedLottos(purchasedLottos);

        WinningLotto winningLotto = getWinningLotto();

        Map<LottoRank, Integer> ranks = lottoService.evaluateLottos(winningLotto, purchasedLottos);
        lottoView.showWinningResult(ranks);
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = lottoView.getWinningNumberFromUser();
        LottoNumber bonusNumber = lottoView.getBonusNumberFromUser();
        return new WinningLotto(lotto, bonusNumber);
    }

    private Money getMoneyFromUser() {
        PurchaseAmount purchaseAmount = lottoView.getPurchaseAmountFromUser();
        return purchaseAmount.toMoney();
    }

}
