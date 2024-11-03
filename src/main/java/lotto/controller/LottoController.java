package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.money.PurchaseAmount;
import lotto.domain.rank.LottoRanks;
import lotto.exception.LottoApplicationException;
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

        LottoRanks lottoRanks = lottoService.evaluateLottos(winningLotto, purchasedLottos);
        double rateOfReturn = lottoRanks.calculateTotalReturnRate(money);
        lottoView.showWinningStatistics(lottoRanks.getRanks(), rateOfReturn);
    }

    private Money getMoneyFromUser() {
        PurchaseAmount purchaseAmount = repeatUntilCorrectInput(lottoView::getPurchaseAmountFromUser);
        return purchaseAmount.toMoney();
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = repeatUntilCorrectInput(lottoView::getWinningNumbersFromUser);
        return repeatUntilCorrectInput(() -> getWinningLotto(lotto));
    }

    private WinningLotto getWinningLotto(Lotto lotto) {
        LottoNumber bonusNumber = lottoView.getBonusNumberFromUser();
        return new WinningLotto(lotto, bonusNumber);
    }

    private <T> T repeatUntilCorrectInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (LottoApplicationException e) {
                lottoView.showLottoApplicationException(e);
            }
        }
    }

}
