package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.domain.PurchaseAmount;
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

        getWinningLotto();
        Lotto winningLotto = Lotto.of(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);

        Map<LottoRank, Integer> ranks = lottoService.evaluateLottos(winningLotto, bonusNumber, purchasedLottos);
        lottoView.showWinningResult(ranks);
    }

    private void getWinningLotto() {
        Lotto lotto = lottoView.getWinningNumberFromUser();
    }

    private Money getMoneyFromUser() {
        PurchaseAmount purchaseAmount = lottoView.getPurchaseAmountFromUser();
        return purchaseAmount.toMoney();
    }

}
